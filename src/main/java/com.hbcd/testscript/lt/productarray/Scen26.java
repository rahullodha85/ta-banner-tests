package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen26 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("Dresses");
		prp.RefineBySize("Medium");

		//clear & validate size refine 
	}
}
