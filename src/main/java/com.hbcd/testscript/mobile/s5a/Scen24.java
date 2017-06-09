package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen24  extends ScenarioMobileSaks{

	@Override
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("testc1@test.com", "123456ab");
		rsp.SelectCreditCard("Visa");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankyouPage();
		
	}

}
