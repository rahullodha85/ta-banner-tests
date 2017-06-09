package com.hbcd.testscript.lt.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen23 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		prp.RefineByLifeStyle("Contemporary");
		prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		prp.ClickFirstItem();
	}
}
