package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen29 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.SearchFor("Boots");
		ValidateProductArray.isPageTitleByKeyWordSearched("Boots");
		//StepLogger.validate(Check.TextPresent, "productArrayCrumb_wk", "boots");
	}
}
