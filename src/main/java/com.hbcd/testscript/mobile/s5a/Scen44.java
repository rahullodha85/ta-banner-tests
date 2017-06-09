package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.validations.s5a.mobile.ValidateNav;
import com.hbcd.base.ScenarioMobileSaks;

public class Scen44 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		ValidateNav.clearSearchWithX("dre");
	}

}
