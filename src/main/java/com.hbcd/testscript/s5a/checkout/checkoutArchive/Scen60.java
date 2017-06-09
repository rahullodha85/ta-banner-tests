package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen60 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);

		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.AddShippingAddress("13 E 49 street", "New York", "New York",
				"10017", true);

		rsp.ClickPlaceOrder();
		yap.Login("checkoutscen02@saks.com", "test123");
		yap.VerifyShippingAddressBook("13 E 49 street");
		yap.removeFromShippingAddressBook("13 E 49 street");
	}

}
