package com.hbcd.testscript.s5a.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen31 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor("0499535450471");
		pdp.AddToBag();
		//pdp.EnterBag();
		//prp.clickFirstItem();
		//validate gift card landing page
	}
}
