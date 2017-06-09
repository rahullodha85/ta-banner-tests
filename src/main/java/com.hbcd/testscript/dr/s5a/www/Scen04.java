package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;

public class Scen04 extends ScenarioSaks{

	/*
	1. From the Main home page, click 'Sale' link from the Top Navigation

	"1. Verify that the Sale page displays the following:
 - Editorials links, Recommends
 - Shop by Designer, Category, Price and Trends options on the left hand navigation"
	 */

	@Override
	public void executeScript() throws Exception {
		Home.closeOverlay();
		nav.ClickNavigationLinks(TopNavLinks.SALE);		
	}
}
