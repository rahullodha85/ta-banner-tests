package com.hbcd.testscript.mobile.s5a.CheckoutEnhancement;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {

//		QC reference: 27173
		
		nav.SearchFor("0438386556826");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.ClickGuestCheckout();
		shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true,"");
		ValidateShipping.hasEmailAddressRequiredText();
		ValidateShipping.hasErrorHighlightedBelow();
}
}