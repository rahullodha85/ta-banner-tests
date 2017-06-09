package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen10 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {

		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
//		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");
		ValidateProductArray.filterBySizeProductArray();

	}
}
