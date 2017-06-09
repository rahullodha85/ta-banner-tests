package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen49 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.SearchFor("Gift");
		ValidateProductArray.isPageTitleByKeyWordSearched("Gift");
		//validate Bridal Boutique
	}
}
