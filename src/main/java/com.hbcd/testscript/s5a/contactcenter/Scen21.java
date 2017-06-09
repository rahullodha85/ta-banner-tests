package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;

public class Scen21 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {

		ccp.LoginWith("csrtest", "csrtest");
		ccHome.SearchByOrderNumber("72293947");
		ValidateCC.hasResult("PayPal");
		ccOrders.ClickBook();
		
	}

}
