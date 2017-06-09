package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen59  extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		
//		nav.SearchFor("0424160097005");
//		pdp.AddToBag(1);
		
		pdp.EnterBag();
		
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com","test123");
		rsp.ClickShippingAndBillingTab();
		shp.ClickEditShippingAddress();
		shp.AddShippingAddress(false, "1 Mickey Mouse drive", "New York", "New York", "10017",false);
		shp.ClickEditBillingAddress();
		shp.AddBillingAddress("14 E 49 street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.ClickCheckout();

		rsp.ClickPlaceOrder();
		yap.Login("checkoutscen02@saks.com", "test123");
		yap.VerifyBillingAddressBook("14 E 49 street");
		nav.ClickSaksYourAccount();
		yap.VerifyShippingAddressBook("1 Mickey Mouse drive");
		yap.removeFromShippingAddressBook("1 Mickey Mouse drive");

		
	}

}
