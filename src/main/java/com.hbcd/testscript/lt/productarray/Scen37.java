package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen37 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		nav.SelectDesigner("Gucci");
		ValidateProductArray.isPageTitleByKeyWordSearched("Gucci");
		nav.ClickShopAll();

		prp.RefineByPrice("$300 - $500");
		prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
		prp.clickFirstItem();
	}
}
