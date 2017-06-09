package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;

public class Scen08 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
		
		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip("72328140", "10017-1055");
		ValidateCC.ValidateTextonOrderSummary("72328140","10017");
		
	}

}
