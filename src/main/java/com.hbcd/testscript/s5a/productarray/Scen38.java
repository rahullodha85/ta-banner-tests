package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen38 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		nav.SelectDesigner("Gucci");
		nav.ClickShopAll();
		prp.RefineByPrice("$300 - $500");
		prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
	}
}
