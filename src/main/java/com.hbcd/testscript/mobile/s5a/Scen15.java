package com.hbcd.testscript.mobile.s5a;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen15 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal();
		lgn.LoginWithPaypal("int_1359045038_per@s5a.com", "test2012");
		papl.continueFromPaypal();
//		rsp.ClickPlaceOrder();
		
	}
}