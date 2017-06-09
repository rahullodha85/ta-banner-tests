package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen58 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		pdp.EnterBag();
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
