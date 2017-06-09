package com.hbcd.testscript.mobile.s5a.CheckoutEnhancement;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.utility.helper.Common;

public class Scen06 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {

		// QC reference: 27174

		nav.SearchFor("0438386556826");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.ClickGuestCheckout();
		shp.AddShippingAddress(true, "12 E 49th Street", "New York",
				"New York", "10017", true, "abc");
		ValidateShipping.InvalidEmailAddressError();
		ValidateShipping.hasErrorHighlightedBelow();

	}
}