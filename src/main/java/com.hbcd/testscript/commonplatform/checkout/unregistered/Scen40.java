package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen40 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.selectShippingMethod("Next Day Air");
		bag.ClickCheckout().ClickGuestCheckout();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword("test123", "test12");
		pap.ClickCheckout();
		ValidatePap.hasPasswordMismatchError();
		pap.EnterPassword("", "");
		pap.ClickCheckout();
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		ValidateRs.hasGiftCardAppliedText();
		/*Waseem: Not placing the Order as the Gift cards are getting used up every transaction.
		Instead validating Gift card is applied. Spoke with Operations(Venky) team on 11/09*/

//		rsp.ClickPlaceOrder();
//		ValidateConfirmation.isGiftCardApplied();
//		yap.CancelOrder(ValidateConfirmation.getOrderNumber(),dataObject.getZipCode());
			
	}
	
	

}
