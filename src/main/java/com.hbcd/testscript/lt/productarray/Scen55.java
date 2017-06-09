package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen55 extends ScenarioChkout{
	//lt script
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		nav.SearchFor("dresses");
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");

		//prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		prp.RefineBy("Brand", "1 State");
		//prp.RefineByPrice("$150 - $300");
	}
}
