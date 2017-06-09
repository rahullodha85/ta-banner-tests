package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen24 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item2 = itemData.get(ItemType.REGULAR);
		
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		rsp.EditShippingAddress(dataObject.getAddress1());
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		nav.SearchFor(item2);
		Alert.Confirm();
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout();
		ValidateRs.isItemPresent(item2);
		rsp.ClickPlaceOrder();
	}
}
