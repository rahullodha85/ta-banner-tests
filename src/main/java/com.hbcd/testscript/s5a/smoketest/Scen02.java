package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen02 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.ClickPlaceOrder();
//		Validate Print Receipt
		
	}

}
