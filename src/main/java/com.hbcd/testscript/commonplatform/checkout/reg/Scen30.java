package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen30 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		
	//pay partial amount from gift card
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		rsp.ApplyGiftCard(dataObject.getGiftCardNumber(), dataObject.getPin());
		
		ValidateRs.isGiftCardApplied();
		rsp.ClickPlaceOrder();
		ValidateRs.isGiftCardApplied();
		//fix the  code for link click
		
		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), dataObject.getZipCode());
		
		
	}
}
