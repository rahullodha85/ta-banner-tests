package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen50 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		
		nav.SearchFor("0419394538714 ");
		ValidatePrp.hasColorSwatches();
}
}