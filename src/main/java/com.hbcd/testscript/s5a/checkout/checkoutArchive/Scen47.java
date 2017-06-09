package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateLl;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen47 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		nav.SearchFor("0457095647182");
		pdp.AddToBag(1);
		nav.SearchFor("0448830169304");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("golamNC5a.com");
		ValidateLl.isEmailValid();
		
		
	}
}
