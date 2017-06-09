package com.hbcd.testscript.s5a.smoketest;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0438369560316");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com", "test123");
		//AddNewDefaultCard: Yes| CardType: Discover| MarkDefault: Yes
		rsp.ClickPlaceOrder();
		yap.GoToMyAcccount();
		yap.Login("saksqa148@saks.com", "test123");
		//ValidateConfirmation.validateCreditCard(name, cvv);
		//ValidateCreditCard:Yes|DeleteCard: Yes

		}

}
