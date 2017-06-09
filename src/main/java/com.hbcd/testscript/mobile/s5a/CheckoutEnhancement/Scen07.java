package com.hbcd.testscript.mobile.s5a.CheckoutEnhancement;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.utility.helper.Common;

public class Scen07 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {

		// QC reference: 27175

		nav.SearchFor("0438386556826");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.ClickGuestCheckout();
		ValidateShipping.hasEmailAddressTextBox();
		ValidateShipping.hasPhoneTextBox();
	}
}