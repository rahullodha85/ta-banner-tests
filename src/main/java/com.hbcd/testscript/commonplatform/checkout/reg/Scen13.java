package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen13 extends ScenarioCommonPlatform {
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);

		//nav.SearchFor(itemData.get(ItemType.REGULAR));
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ApplyPromo(dataObject.getPromoList().get(0));
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		//pap.ContinueCheckoutPaymentPage();
		rsp.EditShippingAddress(dataObject.getAddress1());
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		rsp.ClickPlaceOrder();
	}
}
