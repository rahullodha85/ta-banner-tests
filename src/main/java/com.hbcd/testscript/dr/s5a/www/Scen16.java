package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen16 extends ScenarioSaks{

	/**
	 * 1. Enter a brand (e.x. Prada) in the search box and press <ENTER> (Brand Seach)
	 * */

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("Prada");
		ValidatePrp.hasLogoWithText("Prada");
	}
}
