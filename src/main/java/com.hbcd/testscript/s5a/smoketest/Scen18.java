package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen18 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0438369560316");
		pdp.AddToBag(1);
		
		pdp.EnterBag();
		bag.ApplyPromo("Holiday7");
		bag.ClickCheckout().LoginWith("sukhbirwalia33@yahoo.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York",
				"New York", "10017", false);
		pap.AddNewCreditCard(3);// mastercard
		pap.ClickCheckout();
		ValidateRs.IsTaxApplied();
		rsp.UpdateQuantity("0438369560316","3");

		rsp.ClickPlaceOrder();
		ValidateConfirmation.IsTaxApplied();
		ValidateConfirmation.isThankYouPage();
		


	}

}
