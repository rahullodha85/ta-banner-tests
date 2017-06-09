package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen12 extends ScenarioMobileSaks{
	/*
	"1. Happy Path - Express Checkout

"
	 */
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0427930005071");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal(); // implement msaks bag
		plog.LoginWithPaypal("su_1342452955_per@s5a.com", "test2012");
		pinf.continueFromPaypal();
		rsp.ClickPlaceOrder();
	}
}
