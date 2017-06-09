package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.MakeGift(item1).With("Automation1", "Logo1");
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		ValidateRs.isGift(item1);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}

}
