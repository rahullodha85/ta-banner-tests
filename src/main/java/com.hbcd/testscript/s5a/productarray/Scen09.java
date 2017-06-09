package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.scripting.core.InputData;

public class Scen09 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.SearchFor("");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);

		ValidateProductArray.hasleftNavLinkGroupContainer("Apparel");
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("DRESSES");
		ValidateProductArray.productArrayFilterBy(InputData.get("filterType1").value());

	}
}
