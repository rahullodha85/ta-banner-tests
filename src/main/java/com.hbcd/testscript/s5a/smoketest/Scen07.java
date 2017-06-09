package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen07 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0424168279717");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.ClickShipToMultipleAddresses();
		rsp.ClickPlaceOrder();
	}
}
