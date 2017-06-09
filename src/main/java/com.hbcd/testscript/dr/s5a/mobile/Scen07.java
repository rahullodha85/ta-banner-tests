package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen07 extends ScenarioMobileSaks {

	/**
	 * unregistered happy path changing to rush shipping method
	 */

	@Override
	public void executeScript() throws Exception{
		nav.SearchFor("0412276635709");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.selectShippingMethod("Rush");
	}
}
