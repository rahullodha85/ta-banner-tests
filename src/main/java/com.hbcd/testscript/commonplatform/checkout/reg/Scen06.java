package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen06 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.REGULAR);*/

		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		/*Rahul: Not placing the Order as the Gift cards are getting used up every transaction.
		Instead validating Gift card is applied. Spoke with Operations(Venky) team on 11/09*/
		ValidateRs.hasGiftCardAppliedText();
//		rsp.ClickPlaceOrder();
//		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), dataObject.getZipCode());
	}

}
