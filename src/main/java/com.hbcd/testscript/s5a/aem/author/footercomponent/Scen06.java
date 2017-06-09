package com.hbcd.testscript.s5a.aem.author.footercomponent;

import java.io.*;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;

public class Scen06 extends ScenarioAEMAuthor {

	@Override
	public void executeScript() throws Exception {

		Process p;
		boolean valid = false;

		String Url = Storage.get("url");
		String user = Storage.get("username");
		String pass = Storage.get("password");
		String pagename = Storage.get("Test_Page_Name");
		String curl_command = "curl -u "
				+ user
				+ ":"
				+ pass
				+ " -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/sof/"
				+ pagename + " " + Url + "/etc/replication/treeactivation.html";

		System.out.println("THE COMMAND : " + curl_command);
		try {

			/*
			 * EXAMPLE p = Runtime .getRuntime() .exec(
			 * "curl -u admin:admin -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/saks/sanity_test_author http://localhost:4502/etc/replication/treeactivation.html"
			 * );
			 */

			p = Runtime.getRuntime().exec(curl_command);

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = null;

			try {
				while ((line = input.readLine()) != null) {
					System.out.println(line);
					if (line.contains("<div id=\"Status\">200</div>")) {
						valid = true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (valid) {
				Report.pass("Activated Page");
			} else {
				Report.fail("Failed to Activate page");
			}

			p.waitFor();

		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}

	}
}
