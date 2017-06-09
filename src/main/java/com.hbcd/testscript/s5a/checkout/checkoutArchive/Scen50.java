package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen50 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York", "Manhattan", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		rsp.ClickShippingAndBillingTab();
		shp.ClickEditBillingAddress();
		shp.AddBillingAddress("12 east 49th st", "New York", "Manhattan", "10017",false);
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout(); // REVISIT
		rsp.ClickPlaceOrder();
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}
}
