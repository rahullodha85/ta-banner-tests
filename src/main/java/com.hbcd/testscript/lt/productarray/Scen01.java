package com.hbcd.testscript.lt.productarray;


import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen01 extends ScenarioChkout{
	//Saks Nightly: Included

	public void executeScript() throws Exception {
		nav.SearchFor("");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");
		prp.ClickFirstItem();
		//validate back to result link NOT there
		// click back from browser
	}
}