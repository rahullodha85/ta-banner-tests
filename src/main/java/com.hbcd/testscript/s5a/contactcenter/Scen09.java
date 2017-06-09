package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;

public class Scen09 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
	
		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickOrders();
		ccOrders.SearchByFullname("Automation", "Tester");
		ValidateCC.hasResult("Automation");
		ValidateCC.hasResult("Tester");
	}
}
