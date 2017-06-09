package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen55  extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("saks1@gmail.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.MakeGift(dataObject.getSkuListInfo().get(1)).With("Automation", "test", "no wrap");
		rsp.ChangeShippingMethod("Rush");
		//add more items from RSP 0438369560316
		rsp.ClickPlaceOrder();
//		ValidateRs.hasSignatureOnDelivery("0476703125737");
//		ValidateRs.hasShippingMethodChanged("0476703125737", "Rush");
		//validate expected shipDate
		//validate item 0438369560316 added
	}
}
