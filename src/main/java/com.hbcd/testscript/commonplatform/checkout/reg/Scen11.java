package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen11 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{

		String item1 = dataObject.getSkuListInfo().get(0);
		//nav.SearchFor(itemData.get(ItemType.REGULAR));
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		//pap.ContinueCheckoutPaymentPage();
		rsp.EditBillingAddress(dataObject.getAddress1());
		rsp.ClickPlaceOrder();
	}
}
