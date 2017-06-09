package com.hbcd.testscript.s5a.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen54 extends ScenarioChkout{
	//lt script
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		prp.ClickFirstItem();
	}
}
