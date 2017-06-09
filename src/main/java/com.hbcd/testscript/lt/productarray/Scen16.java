package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;

public class Scen16 extends ScenarioChkout{
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		ValidatePrp.hasItemInfo();
	}
}
