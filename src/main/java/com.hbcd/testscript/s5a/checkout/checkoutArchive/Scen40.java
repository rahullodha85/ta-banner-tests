package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen40 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0438369560316");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.selectShippingMethod("Rush");
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017",false);
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword("test123", "test12");
		pap.ClickCheckout();
		ValidatePap.hasPasswordMismatchError();
		pap.EnterPassword("", "");
		pap.ClickCheckout();
		rsp.ApplyGiftCard("6022990000066301", "9593");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftCardApplied();
		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), "10017");
			
	}
	
	

}
