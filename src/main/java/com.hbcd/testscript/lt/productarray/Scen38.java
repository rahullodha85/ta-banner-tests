package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen38 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Shop All");
		prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
	}
}
