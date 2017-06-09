package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.scripting.core.Navigate;

public class Scen07 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
		
		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickOrders();
		ccOrders.SearchByEmail("testtest@test.com");
		ValidateCC.hasResult("test");
	}

}
