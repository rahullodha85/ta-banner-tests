package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		
		yap.Login("checkoutscen02@saks.com", "test123");
//		Click on Home
		nav.SearchFor("0476703126079");
		
		
		
	}

}
