package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen07 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("Men");
		ValidateProductArray.isPageTitleByKeyWordSearched("MEN");
		prp.ClickFirstItem();
		ValidatePdp.hasUserlandedOnPDPPage();
	}
}
