package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		//String item1 = itemData.get(ItemType.REGULAR);
		String item1 = dataObject.getSkuListInfo().get(0);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		rsp.ChangeShippingMethod("Rush");
		rsp.ToggleSignature(item1);
		ValidateRs.hasSignatureOnDelivery(item1);
		//validate shipping method
		rsp.ClickPlaceOrder();
	}
}