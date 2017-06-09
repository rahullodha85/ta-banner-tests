package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen04 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("");
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		ValidateProductArray.leftNavText("SHOES");
		nav.SelectDesigner("Alexander Wang");
		// validate cartridge: and more... ??
	}
}
