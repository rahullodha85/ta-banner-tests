package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen64 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);		
		miniBagOverlay.clickCheckout();
		bag.ApplyPromo("Holiday7");
		bag.ClickCheckout().LoginWith("sukhbirwalia033@yahoo.com");
		shp.AddShippingAddress(false, "Unit 2050 Box 4190", "Armed Forces Americas", "APO", "34002",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}
}
