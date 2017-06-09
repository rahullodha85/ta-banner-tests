package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen26 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0476971482418");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("drorigin1@s5a.com", "test123");
		rsp.ClickPlaceOrder();
		String orderNumber = ValidateConfirmation.getOrderNumber();
		nav.ClickSaksYourAccount();
		yap.CancelOrder(orderNumber, "10017");
	}
}
