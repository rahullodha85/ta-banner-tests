package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen56 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
	
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		ValidateRs.IsTaxApplied();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.IsTaxApplied();
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}

}
