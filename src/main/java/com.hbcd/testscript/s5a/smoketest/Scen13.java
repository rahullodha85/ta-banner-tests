package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen13 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("ranji_bhola@s5a.com", "summer1234");
		ValidateRs.isAssociateDiscountApplied(true);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		ValidateConfirmation.isShippingChargeApplied();
		
	}

}
