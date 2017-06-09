package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.validations.s5a.mobile.ValidateNav;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen37 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		ValidateNav.hasSearchPredict("dress");
		ValidateNav.hasSearchPredict("dre");
		ValidateNav.clearSearchWithX("dre");
	}
}
