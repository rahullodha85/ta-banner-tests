package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen53 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "1330 7th avenue", "New York", "Manhattan", "10017",false);
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
