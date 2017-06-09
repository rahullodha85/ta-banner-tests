package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;

public class Scen04 extends ScenarioCommonPlatform {
	@Override
	public void executeScript() throws Exception {
		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.Remove(item1);
		nav.SearchFor(item1);
//		Alert.Confirm();
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.UpdateQuantity(item1, "4");
		rsp.UpdateQuantity(item1, "1");
		rsp.UpdateQuantity(item2, "1");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
