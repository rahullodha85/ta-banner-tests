package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen42 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		prp.SortBy(SortOptions.DESIGNERS_ATOZ);
	}
}
