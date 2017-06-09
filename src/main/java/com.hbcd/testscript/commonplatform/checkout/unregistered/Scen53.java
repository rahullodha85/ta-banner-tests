package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen53 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.EnterPassword("test123", "test2321");
		pap.ClickCheckout();
		ValidatePap.hasPasswordMismatchError();
		pap.EnterPassword("t123", "test2321");
		pap.ClickCheckout();
		ValidatePap.hasInvalidPwdDisplayed();
		//validate QAS: Potential Match 
	
	}
}
