package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen46 extends ScenarioChkout{
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
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.MakeGift("0476703126079").With("Automation", "Hello Automation","Logo");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftWrapApplied("0476703126079", "Logo");
		conf.EnterPassword("ds&", "test1234");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test1234");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
	}
}
