package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item1 = dataObject.getSkuListInfo().get(0);

		//String item1 = itemData.get(ItemType.REGULAR);
		nav.SearchFor(item1);
		pdp.AddToBag(1); // 3 quantity
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		//pap.ContinueCheckoutPaymentPage();
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation1", "test123");;
		ValidateRs.isGift(item1);
		rsp.ClickPlaceOrder();
		ValidateRs.isGift(item1);
	}
}
