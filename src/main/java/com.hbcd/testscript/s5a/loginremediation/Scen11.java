package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateLogin;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen11 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0400087574824");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa1481saks.com");
		ValidateLogin.hasUnregEmailError();
	}
}
