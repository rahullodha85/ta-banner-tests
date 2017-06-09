package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen40 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		nav.SelectDesigner("Gucci");
		prp.RefineByPrice("$300 - $500");
		prp.SortBy(SortOptions.SALE_SHOWFIRST);
	}
}
