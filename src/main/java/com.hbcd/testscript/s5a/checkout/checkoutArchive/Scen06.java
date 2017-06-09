package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen06 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftCardApplied();
		
//		Validate Gift Card on Print Receipt pending

		yap.CancelOrder(ValidateConfirmation.getOrderNumber(),"10017");
	}

}
