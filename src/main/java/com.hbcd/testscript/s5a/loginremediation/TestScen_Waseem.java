package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.HomePage;

public class TestScen_Waseem extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
	
		ValidateYourAcc.ValidateNonExistingAccount();
		
	}

}
