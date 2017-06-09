package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioMobileSaks{
	@Override
	public void executeScript() throws Exception{
		nav.SearchFor("0412264496516 ");
		ValidatePrp.isLandingPage();
		
	}

}
