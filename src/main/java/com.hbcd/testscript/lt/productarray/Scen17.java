package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;

public class Scen17 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.SearchFor("dresses");

		ValidateProductArray.isPageTitleByKeyWordSearched("dresses");
		ValidatePrp.hasStrikeThroughPriceinPA();
	}
}
