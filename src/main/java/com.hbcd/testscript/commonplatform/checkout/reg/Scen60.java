package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen60 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);

		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.AddShippingAddress("13 E 49 street", "New York", "New York",
				"10017", true);

		rsp.ClickPlaceOrder();
		yap.Login("checkoutscen02@saks.com", "test123");
		yap.VerifyShippingAddressBook("13 E 49 street");
		yap.removeFromShippingAddressBook("13 E 49 street");
	}

}
