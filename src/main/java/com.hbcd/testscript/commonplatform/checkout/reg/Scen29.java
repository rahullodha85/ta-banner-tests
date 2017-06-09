package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen29 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item2 = itemData.get(ItemType.PREORDER);
		
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		ValidateRs.isPreOrderItemInCart(item2);
		rsp.ClickPlaceOrder();
		//needs to be improved for readability
		ValidateRs.isPreOrderItemInCart(item2);
		
	}
}
