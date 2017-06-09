package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen41 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0438369560316");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York","10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword("test", "test");
		pap.ClickCheckout();
		ValidatePap.hasInvalidPwdDisplayed(); 
		pap.EnterPassword("test123", "test12");
		pap.ClickCheckout();
		ValidatePap.hasPasswordMismatchError();
		pap.EnterPassword("test123", "test123");
		pap.ClickCheckout();
		rsp.MakeGift("0476703126079").With("Automation", "test");
		rsp.RemoveGift("0476703126079");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		yap.Login(Storage.get("email"), "test123");
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}

}
