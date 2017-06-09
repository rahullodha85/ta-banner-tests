package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.scripting.core.Navigate;

public class Scen24 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {

		ccp.LoginWith("csr_agent", "csr_agent");		
		ccNav.ClickCustomers();
		ccCustomers.SearchByCustomerNumber("66431177");
		ccCustomers.ChangeEmailPw("changeme");
		
	}

}
