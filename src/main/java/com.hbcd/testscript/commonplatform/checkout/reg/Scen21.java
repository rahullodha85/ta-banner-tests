package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen21 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item3 = itemData.get(ItemType.PREORDER);*/
		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(item2); // PRE ORDER ITEM
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		//pap.ContinueCheckoutPaymentPage();
//		ValidateRs.isPreOrderItemInCart(dataObject.getSkuListInfo().get(2)); //dynamic check
		rsp.ClickPlaceOrder();
//		ValidateRs.isPreOrderItemInCart(dataObject.getSkuListInfo().get(2));
	}
}
