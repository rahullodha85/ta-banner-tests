package com.hbcd.testscript.lt.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen21 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		prp.RefineByLifeStyle("Contemporary");
	}
}
