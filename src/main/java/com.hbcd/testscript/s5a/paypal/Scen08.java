package com.hbcd.testscript.s5a.paypal;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen08 extends ScenarioSaks{
	@Override
	public void executeScript() throws Exception {
	
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		pdp.EnterBag();

		bag.ClickCheckout().LoginWith("testc1@test.com", "123456ab");
		rsp.EditCreditCard("", "PayPal", "");
		ValidateRs.hasPaypalNotApplied();
		
	}
}
