package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen63 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
		nav.SearchFor("0434108451516");
		pdp.AddToBag(1);		
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
		shp.AddShippingAddress(false, "13 East 49th St", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		//add preorder validation
		ValidateRs.isAssociateDiscountApplied(false);
		rsp.ClickPlaceOrder();
		ValidateRs.isAssociateDiscountApplied(true);
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
		
	}
}
