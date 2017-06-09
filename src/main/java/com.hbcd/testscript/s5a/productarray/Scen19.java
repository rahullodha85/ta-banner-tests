package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		prp.RefineBy("Designer", "3.1 Phillip Lim");
		ValidatePrp.hasSaksExclusiveTag();
	}
}
