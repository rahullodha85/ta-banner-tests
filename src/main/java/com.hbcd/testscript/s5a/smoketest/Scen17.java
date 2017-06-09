package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen17 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		
		pdp.EnterBag();
		bag.ApplyPromo("Holiday7");
		bag.ClickCheckout().LoginWith("sukhbirwalia33@yahoo.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York",
				"New York", "10017", false);
		pap.AddNewCreditCard(3);// mastercard
		pap.ClickCheckout();
		
		rsp.MakeGift("0476715292991").With("Automation", "Test1", "logo");


		rsp.ClickShipToMultipleAddresses();
		rsp.EnterNewShippingAddress("0476715292991", "abd blvd", "NEW YORK", "New York", "10017",true);
		rsp.ClickContinueCheckOut();
		

		rsp.ClickPlaceOrder();
		ValidateConfirmation.isShippingChargeApplied();
		ValidateConfirmation.isGiftWrapApplied("0476715292991", "Test1");
		ValidateConfirmation.ShippingAddressContains("abd blvd");
		//ValidateExpectedShipDate: Yes

		
	}

}
