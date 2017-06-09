package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen43 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.PersonalizeAddToBag(1,"Personalized text");
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//mastercard
//		pap.EnterPassword();
		pap.ClickCheckout();
		ValidateRs.isDropship(dataObject.getSkuListInfo().get(0));
		ValidateRs.isPersonalized(dataObject.getSkuListInfo().get(1), "Personalized text");
		rsp.ClickPlaceOrder();
		conf.EnterPassword("test123", "test13");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
		conf.EnterPassword("test", "test");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test123");
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}

}
