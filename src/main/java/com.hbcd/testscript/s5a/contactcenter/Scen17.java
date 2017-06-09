package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;

public class Scen17 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {

		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip("72292812", "");
		ccOrders.ClickBook();
		ValidateCC.hasOrderHistory("72292812");
		ccOrders.ClickViewOrderLog();
		ValidateCC.hasOrderLog("72292812");
		ccOrders.ClickEmailHistory();
		ValidateCC.hasEmailHistory("72292812");
		
		
		
		
		
	}

}
