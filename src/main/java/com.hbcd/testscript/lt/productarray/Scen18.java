package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen18 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		ValidatePrp.hasItemInfo();
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		ValidateProductArray.isPageTitleByKeyWordSearched("SHOP ALL");
	}
}
