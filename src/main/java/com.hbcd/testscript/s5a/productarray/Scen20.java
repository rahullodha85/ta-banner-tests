package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen20 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.SearchFor("Shoes");
		ValidateProductArray.isPageTitleByKeyWordSearched("SHOES");
		ValidateProductArray.hasProductInfoOnPa();
	}
}
