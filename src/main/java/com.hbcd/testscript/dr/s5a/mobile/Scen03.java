package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.enums.SortOptions;

public class Scen03 extends ScenarioMobileSaks{
	@Override
	public void executeScript() throws Exception {
		nav.EnterPrp("APPAREL"); //clicknavigation implementation - vevin
		sec.ClickDresses();
		sec.ClickDay();
		prp.RefineByDesigner("A Detacher");
		prp.SortBy(SortOptions.SALE_SHOWFIRST);
	}
}
