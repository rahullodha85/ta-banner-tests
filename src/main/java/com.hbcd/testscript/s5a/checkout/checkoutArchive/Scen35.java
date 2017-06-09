package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen35 extends ScenarioChkout {
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		// nav.SearchFor("0468040012412");
		pdp.AddToBag(1);
		// nav.SearchFor(dataObject.getSkuListInfo().get(1));
		// pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID());
		shp.AddBillingAddress(dataObject.getAddress1(), dataObject.getState(),
				dataObject.getCity(), dataObject.getZipCode(), false);
		// shp.AddShippingAddress(false, dataObject.getAddress1(),
		// dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),
		// false);
		pap.AddNewCreditCard(3);// mastercard
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		
//		ValidateConfirmation.hasCreditCard(Storage.get("ccNumber"));
	}
}
