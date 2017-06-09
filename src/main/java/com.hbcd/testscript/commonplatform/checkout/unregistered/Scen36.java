package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen36 extends ScenarioCommonPlatform {
	public void executeScript() throws Exception{

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ApplyPromo("15PCTOFF");//Promo Code for Off5th Migration
		bag.ClickCheckout().LoginWith(dataObject.getEmailID());
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout();
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		/*Waseem: Not placing the Order as the Gift cards are getting used up every transaction.
		Instead validating Gift card is applied. Spoke with Operations(Venky) team on 11/09*/
		ValidateRs.hasGiftCardAppliedText();
//		rsp.ClickPlaceOrder();
//		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), dataObject.getZipCode());
	}
}
