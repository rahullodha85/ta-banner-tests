package com.hbcd.testscript.lt.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.scripting.core.InputData;

public class Scen31 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.SearchFor(InputData.get("item1").value());
		pdp.AddToBag();
		//pdp.EnterBag();
		//prp.clickFirstItem();
		//validate gift card landing page
	}
}
