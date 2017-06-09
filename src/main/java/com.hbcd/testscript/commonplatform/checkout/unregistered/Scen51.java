package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen51  extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
		shp.ClickCheckoutOptionalAddressConfirmation();
		//rsp.AddShippingAddress("12 east 49th st", "New York", "NY", "10017",false);
		//rsp.AddBillingAddress("12 east 49th st", "New York", "NY", "10017", "USA",false);
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		//validate non associate discount
//		conf.CreateAccount();
//		conf.GoToYourAccount();
		conf.EnterPassword("ds&", "test1234");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test1234");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
	}
}
