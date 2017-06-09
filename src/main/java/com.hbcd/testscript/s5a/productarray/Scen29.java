package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Scen29 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("Boots");
		ValidateProductArray.isPageTitleByKeyWordSearched("Boots");
		//StepLogger.validate(Check.TextPresent, "productArrayCrumb_wk", "boots");
	}
}
