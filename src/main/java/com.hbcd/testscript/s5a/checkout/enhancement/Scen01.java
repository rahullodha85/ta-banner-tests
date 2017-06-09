package com.hbcd.testscript.s5a.checkout.enhancement;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioChkout {

	public void executeScript() throws Exception {

		nav.SearchFor("0454507760989");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("newcheckout");
		rsp.ClickPlaceOrder();
	}
}
