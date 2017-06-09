package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen12 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal();
		
		lgn.LoginWithPaypal("su_1342452955_per@s5a.com", "test2012");
		papl.continueFromPaypal();

		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
		ValidateConfirmation.PaymentSectionHas("PayPal");
		ValidateConfirmation.PaymentSectionHas("su_1342452955_per@s5a.com");

	}
}