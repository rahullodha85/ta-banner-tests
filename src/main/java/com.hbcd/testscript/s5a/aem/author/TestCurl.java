package com.hbcd.testscript.s5a.aem.author;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCurl {

	public static void main(String args[]) {
		Process p;
		boolean valid = false;

		try {
			// if(Storage.get("environment").equals("local")){
			// p =
			// Runtime.getRuntime().exec("curl -u admin:admin -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/saks/en_us/sanity_test_author1 http://localhost:4502/etc/replication/treeactivation.html");
			// } else {
			p = Runtime
					.getRuntime()
					.exec("curl -u admin:admin -F cmd=activate -F ignoredeactivated=true -F onlymodified=false -F path=/content/saks/en_us/sanity_test_author http://dev-hbc-author1.adobecqms.net:4502/etc/replication/treeactivation.html");
			// }

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = null;

			try {
				while ((line = input.readLine()) != null) {
					System.out.println(line);
					if (line.contains("Activated 1")) {
						valid = true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// if(valid){ Report.pass("Activated Page");
			// }else{Report.fail("Failed to Activate page");}

			p.waitFor();

		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
			System.out.println("Failed " + e1.getStackTrace().toString());
		}

	}
}
