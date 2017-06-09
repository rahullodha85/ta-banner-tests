package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen64 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);		
		pdp.EnterBag();
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
