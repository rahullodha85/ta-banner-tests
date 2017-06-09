package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen08 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0406754977757");
		pdp.AddToBag(1);
		nav.SearchFor("0412264496516");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.Remove("0406754977757");
		ValidateBag.ValidateSubTotal("0412264496516");
		
		
	}
}