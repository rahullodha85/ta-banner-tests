package com.hbcd.testscript.s5a.aem.author.subfootercomponent;

import java.io.*;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;

public class Scen06 extends ScenarioAEMAuthor {

	@Override
	public void executeScript() throws Exception {

		// public static void main(String args[]){
		Process p;
		boolean valid = false;

		try {
			if (Storage.get("environment").equals("local")) {
				p = Runtime
						.getRuntime()
						.exec("curl -u admin:admin -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/saks/sanity_test_author http://localhost:4502/etc/replication/treeactivation.html");
			} else {
				p = Runtime
						.getRuntime()
						.exec("curl -u admin:@W2rhLW>i@Wo9 -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/saks/sanity_test_author http://dev-hbc-author1.adobecqms.net:4502/etc/replication/treeactivation.html");
			}

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = null;

			try {
				while ((line = input.readLine()) != null) {
					// System.out.println(line);
					if (line.contains("Activated 1")) {
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
