package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen25 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {

		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");
		prp.RefineByLifeStyle("Lifestyle");
		prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		prp.RefineBy("Designer", "ABS");
		prp.RefineByPrice("$150 - $300");
	}
}
