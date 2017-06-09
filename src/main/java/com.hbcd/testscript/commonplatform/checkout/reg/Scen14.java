package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen14 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item1 = itemData.get(ItemType.DROPSHIP);
		String item2 = itemData.get(ItemType.DROPSHIP);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		ValidateRs.isDropship(item1);
		ValidateRs.isDropship(item2);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
