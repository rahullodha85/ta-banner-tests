package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioCommonPlatform;


public class Scen35 extends ScenarioCommonPlatform {
	public void executeScript() throws Exception {
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.REGULAR);*/
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
		ValidateShippingBilling.hasUserlandedOnShippingAndBilling("Shipping & Billing");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
				dataObject.getCity(), dataObject.getZipCode(), false);
		pap.AddNewCreditCard(3);// mastercard
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();

	}
}
