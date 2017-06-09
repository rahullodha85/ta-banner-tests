package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioSaks;

public class Scen06 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
//		Home.closeOverlay();
		nav.ClickTopNavLink("Sale");
		nav.ClickLeftNavLink("Under $50");
		ValidateProductArray.ItemsInPriceRange("Under $50");
	}
}
