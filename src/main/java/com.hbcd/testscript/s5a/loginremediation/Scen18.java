package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.base.ScenarioSaks;

public class Scen18 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		//yap.GoToMyAcccount();
		yap.Login("saksqa147@saks.com","test123");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa147@saks.com","test123");
		rsp.ClickPlaceOrder();
		yap.GoToMyAcccount();
		
	

	}

}
