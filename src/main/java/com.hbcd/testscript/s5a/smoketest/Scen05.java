package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0424168279717");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.MakeGift("0424168279717").With("Automation", "Test", "Logo");
		bag.MakeGift("0476715292991").With("Automation1", "Test123", "Logo");
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		ValidateRs.isGift("0424168279717");
		ValidateRs.isGift("0476715292991");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}

}
