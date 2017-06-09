package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen38 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "13 E 49 street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout();
		rsp.ChangeShippingMethod("rush");
		rsp.ClickPlaceOrder();
		conf.EnterPassword("ds&", "test1234");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test1234");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
		
		
	}

}
