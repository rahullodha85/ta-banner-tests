package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen45 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		nav.SearchFor("0457095647182");
		pdp.AddToBag(1);
		nav.SearchFor("0448830169304");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
		shp.AddShippingAddress(false, "13 East 49th St", "New York", "New York", "10017",false);
		pap.UpdateQuantity("0476703126079","4");
		pap.AddNewCreditCard(3);
//		ValidatePymt.isQuantityUpdatedTo("0476703126079","4");
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}
}
