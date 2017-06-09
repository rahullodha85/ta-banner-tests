package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;

public class Scen06 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("Dresses");
		ValidatePrp.hasSearchResultsTitle("DRESSES");
		ValidatePrp.hasNavRefineButtons();
	}
}
