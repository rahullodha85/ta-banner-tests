package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateLogin;
import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen12 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		
		ValidateNav.isvisibleDrpDown();
	}
}
