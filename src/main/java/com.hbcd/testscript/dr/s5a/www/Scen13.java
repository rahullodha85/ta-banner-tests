package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen13  extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("CHANEL");
		ValidateProductArray.hasBannerLandingPage("CHANEL");
		nav.ClickLeftNavLink("MAKEUP");
		ValidateProductArray.hasBannerItemCategory("Chanel Makeup");
	}
}
