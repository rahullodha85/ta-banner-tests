package com.hbcd.testscript.s5a.aem.glassie;

import com.hbcd.base.ScenarioAEMGlassie;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.exception.ScriptFailException;
import com.mongodb.util.JSON;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ScenGlassieJava extends ScenarioAEMGlassie {
	/**
	 * happy paths // Commerce page - product_test.html glassie mapped //
	 * content page - sanity_test_author.html // error check // AEM is Down -
	 * 503.html error // glassie is down - 503 error // Commerce page - Play is
	 * down - 404.html redirect // Content page that contains NSI - Play is down
	 * - Play errors within // markup <!--> // Response header - response code
	 * 404,500,200 etc and cookie // request header - login, shopping cart - but
	 * we are passing only // cache-control headers
	 */

	private static final long serialVersionUID = 1L;
	String expectedValue = "";

	@SuppressWarnings("rawtypes")
	@Override
	public void executeScript() throws Exception {

		System.out.println("argument data = " + argData);
        String[] ret = makeCurlUrl(argData);

		//System.out.println("From Scenario path : " + ret[0]);

		Process p;
		boolean valid = false;
		String message = "No Content Returned by Glassie";
		String header = ret[2];

		try {
			p = Runtime.getRuntime().exec(ret[0]);

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = "";
			String content = "";
			//System.out.println("Product Name should be : " + ret[1]);
			String prodname = ret[1];

			if (header.contains("true")) {
				Object retData[] = validateContent(input, line, content, valid,
						message, prodname, expectedValue);
				valid = (boolean) retData[0];
				message = (String) retData[1];
			} else {
				Object retData[] = validateContent(input, line, content, valid,
						message, prodname, expectedValue);
				valid = (boolean) retData[0];
				message = (String) retData[1];
			}

			if (valid) {
				if (expectedValue.contains("fail")) {
					Report.fail(message, "");

				} else {
					Report.pass(message, "");
				}

			} else {
				if (expectedValue.contains("pass")) {
					Report.fail(message, "");
				} else {
					Report.pass(message, "");
				}
			}

			p.waitFor();

			// StepLogger.validate(Check.ObjectPresent, "NOPE");

		} catch (IOException | InterruptedException e1) {
			// e1.printStackTrace();
			Report.log("IO error", "Error while executing Curl",
					"Failed to call", "Glassie NOT available", "Fail",
					"NO screenshots");
			// System.out.println("Glassie not available " +
			// e1.getStackTrace().toString());
		}

		catch (ScriptFailException e2) {
			// e2.printStackTrace();
			// Report.log("Script Failed error",
			// "Error while executing Script","Failed to execute Script",
			// "Script Failure", "Fail","NO screenshots");
			// System.out.println("Script FAILED " +
			// e2.getStackTrace().toString());
		}

		catch (Exception e3) {
			// e2.printStackTrace();
			Report.log("Script Failed error", "Error while executing Script",
					"Failed to execute Script", "Script Failure", "Fail",
					"NO screenshots");
			// System.out.println("Script FAILED " +
			// e2.getStackTrace().toString());
		}

	}

	public String[] makeCurlUrl(String argData) {

		HashMap x = (HashMap) JSON.parse(argData);
		String url = (String) x.get("ServiceURL");
		String res = (String) x.get("ResourceMappingPath");
		String header = (String) x.get("Header");
		expectedValue = (String) x.get("Expected");
		String path;

		if (header.contains("true")) {
			path = "curl -I ";
		} else {
			path = "curl ";
		}

		// path = path.concat(url).concat(":3002/").concat(res);
		path = path.concat(url).concat(res);

		String prodName = (String) x.get("productName");

		String[] ret = { path, prodName, header };
        System.out.println("return value = " + ret[0]);
		return ret;
	}

	public Object[] validateContent(BufferedReader input, String line,
			String content, boolean valid, String message, String prodname,
			String expectedvalue) throws Exception {

		try {
			while ((line = input.readLine()) != null) {
				// System.out.println("WRITING THE LINE HERE: " +line);

				content = content + line;
				if (!line.isEmpty()) {
					// open if here
					if (!prodname.contains("NONE")) {

						if (content.contains(prodname)) {
							valid = true;
							message = "Product Name " + prodname
									+ " & ID match! - PASS";
							// Report.log(prodName, message, "PASSED", "");
						} else if (line
								.contains("NSI ERROR - render: compName not supported")) {
							valid = false;
							message = "NSI Error - Component NOT supported";
						} else if (line
								.contains("Gateway Timeout: can't connect to remote host")) {
							valid = false;
							message = "Glassie SERVER is DOWN";

						} else if (line.contains("404.html")) {
							valid = false;
							message = "404 Error or AEM is DOWN";

						} else if (line.contains("Technical Error encountered")) {
							valid = false;
							message = "PLAY is DOWN - Technical Error Encountered";

						} else if (line.contains("No Status")) {
							valid = false;
							message = "Glassie SERVER is DOWN";

						} else if (line.contains("Page Not Found or Missing")) {
							valid = false;
							message = "Product does not exist or PLAY is down";

						} else if (line
								.contains("The Requested Page couldn\'t be Found or is Missing")) {
							valid = false;
							message = "The Requested Page couldn't be Found or is Missing.";

						} else {
							valid = false;
							message = "Invalid Product data";
							// Report.error("Failed Report ERROR", "");
							// Report.log(prodName, message, "FAILWD", "");
						}
					} else {

						if (line.contains("<!-- NSI ERROR - render: compName not supported -->")) {
							valid = false;
							message = "NSI Error - Component NOT supported";

						} else if (line
								.contains("Gateway Timeout: can't connect to remote host")) {
							valid = false;
							message = "Glassie SERVER is DOWN";

						} else if (line.contains("404.html")) {
							if (expectedvalue.contains("404")) {
								valid = true;
								System.out.println("HERE PASS");
							} else {
								valid = false;
							}
							message = "404 Error - AEM is DOWN";

						} else if (line.contains("Technical Error encountered")) {
							valid = false;
							message = "PLAY is DOWN - Technical Error Encountered";

						} else if (line.contains("No Status")) {
							valid = false;
							message = "Glassie SERVER is DOWN";

						} else if (line
								.contains("The Requested Page couldn\'t be Found or is Missing")) {
							valid = false;
							message = "The Requested Page couldn't be Found or is Missing.";

						} else {
							valid = true;
							message = "Page exists - PASS";
						}

					}

				} // big if closed
				else {
					valid = false;
					message = "NO CONTENT FOUND!";
				}
			} // while
			System.out.println("Content IS : " + content);
		} catch (Exception e) {
			// e.printStackTrace();
			Report.fail("No content returned from Glassie", "");
			try {
				Report.log("ReadLine error", "Error while reading response",
						"Failed to read", "Response read error", "Fail",
						"NO screenshots");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		Object[] ret = { valid, message };
		//System.out.println("The Result : " + valid + " -- " + message + "---"
		//		+ content);
		return ret;
	}

}
