package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen02 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.SearchFor("Dresses");
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");
		prp.ClickFirstItem();
		ValidatePdp.hasAddToBagButton();

	}
}
