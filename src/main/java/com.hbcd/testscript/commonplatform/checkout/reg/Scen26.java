package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateLogin;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;


public class Scen26 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().forgotPassword(dataObject.getEmailID());
		ValidateLogin.isPasswordReset();
		
	}
}
