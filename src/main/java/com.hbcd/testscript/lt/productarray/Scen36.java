package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen36 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		//nav.SelectDesigner("Gucci");
		//sec.ClickSandals();
		nav.ClickShopAll();
		ValidateProductArray.isPageTitleByDesigner("SALE: SHOES");
		//validate shop by category
		//validate LHN
	}
}
