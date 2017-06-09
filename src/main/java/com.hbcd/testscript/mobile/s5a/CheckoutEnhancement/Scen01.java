package com.hbcd.testscript.mobile.s5a.CheckoutEnhancement;

import com.hbcd.banner.mobile.saks.validations.ValidateLogin;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {
		
//		QC reference: 27169
		
		nav.SearchFor("0438386556826");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.CheckOut();
		ValidateLogin.hasSignInCheckOutButton();
		ValidateLogin.hasGuestCheckOutButton();
		
}
}