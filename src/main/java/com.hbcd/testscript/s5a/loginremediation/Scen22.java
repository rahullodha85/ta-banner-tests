package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen22 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0400087574824");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa147@saks.com", "test123");
		rsp.ClickPlaceOrder();
		yap.Go();
		yap.Login("saksqa147@saks.com", "test123");
	}
}
