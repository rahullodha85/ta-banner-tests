package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateLogin;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen25 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		ValidateLogin.hasInvalidPasswordError();
		
		
		
	}
}
