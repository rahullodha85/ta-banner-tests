package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;

public class Scen05 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.ClickTopNavLink("Sale");
		nav.ClickNavigationLinks(TopNavLinks.SALE);
		ValidateProductArray.isPreviousAndPresentPrice();
	}
}
