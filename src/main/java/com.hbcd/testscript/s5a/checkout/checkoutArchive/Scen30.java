package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen30 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
	//pay partial amount from gift card
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();	
		
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		
		ValidateRs.isGiftCardApplied();
		rsp.ClickPlaceOrder();
		ValidateRs.isGiftCardApplied();
		//fix the  code for link click
		
		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), dataObject.getZipCode());
		
		
	}
}
