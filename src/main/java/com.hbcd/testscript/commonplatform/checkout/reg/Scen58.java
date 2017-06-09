package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen58 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		
		rsp.EditCreditCard("Hello World", "Discover", "6011000990911111");
	//	rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
		yap.Login("checkoutscen02@saks.com", "test123");
		yap.ClickPaymentInformation();
		//yap.VerifyCreditCard("6011000990911111");
		ValidateYourAcc.ValidateCC("6011000990911111");
		yap.RemoveCreditCard();

		

		
	}

}
