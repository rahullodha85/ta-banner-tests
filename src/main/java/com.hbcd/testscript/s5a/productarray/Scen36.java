package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen36 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		nav.SelectDesigner("Gucci");
		sec.ClickSandals();
		nav.ClickShopAll();
		ValidateProductArray.isPageTitleByDesigner("Gucci");
		//validate shop by category
		//validate LHN
	}
}
