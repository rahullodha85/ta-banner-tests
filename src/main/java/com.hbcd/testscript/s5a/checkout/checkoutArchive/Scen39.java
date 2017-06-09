package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen39 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017",true);
//				shp.AddBillingAddress("12 E 49 street", "New York", "New York", "10017",true);
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword("test123", "test123");
		pap.ClickCheckout();
		rsp.MakeGift("0476703126079").With("Automation", "test1","no wrap");
		rsp.ClickShipToMultipleAddresses();
		rsp.EnterNewShippingAddress("0476703126079", "abd blvd", "NEW YORK", "New York", "10017",true);
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
	
		ValidateConfirmation.ShippingAddressContains("abd blvd");
		ValidateConfirmation.isGiftWrapApplied("0476703126079", "no wrap");
		ValidateConfirmation.isShippingChargeApplied();
		ValidateConfirmation.ShippingMethod("Standard","0448882328957");

	}
}
