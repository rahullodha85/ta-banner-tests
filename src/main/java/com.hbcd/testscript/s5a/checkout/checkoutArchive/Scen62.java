package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen62 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
		nav.SearchFor("0457168495757");
		pdp.PersonalizeAddToBag(1);
//		ValidatePdp.isPersonalizedErrorMessageDisplayed();
		
		
	}
}
