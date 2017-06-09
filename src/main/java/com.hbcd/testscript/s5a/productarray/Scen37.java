package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen37 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		nav.SelectDesigner("Gucci");
		ValidateProductArray.isPageTitleByKeyWordSearched("Gucci");
		nav.ClickShopAll();

		prp.RefineByPrice("$300 - $500");
		prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
		prp.clickFirstItem();
	}
}
