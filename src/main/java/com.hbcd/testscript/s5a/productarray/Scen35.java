package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen35 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		nav.SelectDesigner("Gucci");
		sec.ClickSandals();
		prp.RefineBySize("6");
		prp.RemoveAllFilters();
	}
}
