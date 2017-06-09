package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen43 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		prp.SortBy(SortOptions.SALE_SHOWFIRST);
	}
}
