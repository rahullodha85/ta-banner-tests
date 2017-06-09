package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen04 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0424168279717");
		pdp.AddToBag(2);
		nav.SearchFor("0438387040881");
		pdp.AddToBag(3);
		nav.SearchFor("0438369560316");
		pdp.AddToBag(4);
		pdp.EnterBag();
		bag.Remove("0438369560316");
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.Remove("0476715292991");
		
		rsp.UpdateQuantity("0438387040881", "4");
		rsp.ClickPlaceOrder();

		
	}

}
