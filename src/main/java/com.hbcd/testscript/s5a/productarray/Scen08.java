package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen08 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		prp.ClickFirstItem();
		ValidatePdp.hasUserlandedOnPDPPage();
	}
}
