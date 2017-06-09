package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen20 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.SearchFor("Shoes");
		ValidateProductArray.isPageTitleByKeyWordSearched("SHOES");
		ValidateProductArray.hasProductInfoOnPa();
	}
}
