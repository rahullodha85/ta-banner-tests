package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen21 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		prp.RefineByLifeStyle("Contemporary");
	}
}
