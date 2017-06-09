package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen24 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		//ValidateProductArray.hasBreadcrumbTitleAppeared("Women");
		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		Thread.sleep(5000);
		prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		//fix it later
		//prp.RefineBy("Designer","ABS");
	}
}
