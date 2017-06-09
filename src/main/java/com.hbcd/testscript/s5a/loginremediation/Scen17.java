package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioSaks;

public class Scen17 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		yap.GoToMyAcccount();
		//logintier:level2
		ValidateYourAcc.ValidateLink("ORDER HISTORY");
		ValidateYourAcc.ValidateLink("ACCOUNT AND EMAIL SETTINGS");
		ValidateYourAcc.ValidateLink("SHIPPING ADDRESS BOOK");
		ValidateYourAcc.ValidateLink("BILLING ADDRESS BOOK");
		ValidateYourAcc.ValidateLink("PAYMENT METHOD");
		ValidateYourAcc.ValidateLink("ONLINE BILLING FOR SAKS CREDIT CARD HOLDERS");


	}

}
