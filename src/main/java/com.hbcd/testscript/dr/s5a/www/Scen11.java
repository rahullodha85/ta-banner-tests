package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;

public class Scen11 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.isPageTitle("WOMEN'S APPAREL");
		ValidateProductArray.isTrendEventsPresent("Trends & Events");
//		prp.ClickFirstFromTrendsEvents();
	}
}
