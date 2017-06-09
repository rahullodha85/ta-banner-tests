package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen54 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "14 E 49th Street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.EnterPassword("test123", "test2321");
		pap.ClickCheckout();
		ValidatePap.hasPasswordMismatchError();
		pap.EnterPassword("t123", "test2321");
		pap.ClickCheckout();
		ValidatePap.hasInvalidPwdDisplayed();
		//validate QAS: Exact Match
		
	}
}
