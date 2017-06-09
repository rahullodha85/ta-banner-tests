package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0428408863902");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo("Holiday7");
		ValidateBag.isPromoApplied("Holiday7");
		bag.UpdateQuantity("0476715292991", "3");
		ValidateBag.ValidatePrice("0476715292991");
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.MakeGift("0476715292991").With("Hello", "World", "logo");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isPromoApplied("Holiday7");

	}

}
