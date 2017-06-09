package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen06 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		nav.SearchFor("0424168279717");
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		rsp.ApplyGiftCard("6015990000091696", "3743");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftCardApplied();
		ValidateConfirmation.isThankYouPage();
		// Validate GC on Print Receipt
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		yap.CancelOrder(Storage.get("orderNumber"), "10017");

	}

}
