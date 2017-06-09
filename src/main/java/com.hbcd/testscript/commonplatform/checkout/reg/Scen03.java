package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen03 extends ScenarioCommonPlatform {

	
	@Override
	public void executeScript() throws Exception {
		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankyouPage();
		
	}

	
}
