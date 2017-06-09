package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen15 extends ScenarioSaks{

	/*
	"1.From the Top Navigation, enter a keyword (e.x Shoes) on the search box and press <ENTER>

(Keyword Seach)"	"1. Product array page is displayed showing items with the corresponding searched keyword
   All categories with the corresponding searched keyword are displayed on the left hand navigation
   Page Title should display and includes the search term"
	 */


	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("Shoes");
		ValidatePrp.hasBreadCrumb("SHOES");
	}
}
