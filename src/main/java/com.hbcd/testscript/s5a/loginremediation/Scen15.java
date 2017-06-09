package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateYap;
import com.hbcd.base.ScenarioSaks;

public class Scen15 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		yap.GoToMyAcccount();
		yap.CreateAccount("sukhbirwaliachutiyapahaiek33@yahoo.com");
		ValidateYap.isDisplayed();
		yap.ClickAddShipping().fillNewProfileShippingAddress("","13 E 49th St", "New York", "New York", "10017");
		yap.ClickAddBilling().fillNewProfileBillingAddress("United States","13 E 49th St", "New York", "New York", "10017");
		
	}

}
