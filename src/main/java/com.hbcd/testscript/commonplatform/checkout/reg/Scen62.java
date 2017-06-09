package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen62 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		
		nav.SearchFor("0457168495757");
		pdp.PersonalizeAddToBag(1);
//		ValidatePdp.isPersonalizedErrorMessageDisplayed();
	}
}
