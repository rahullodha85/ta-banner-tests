package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioCommonPlatform {
	public void executeScript() throws Exception {
		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ApplyPromo(dataObject.getPromo());
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
				dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
