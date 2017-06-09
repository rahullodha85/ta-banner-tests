package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;

public class Scen02 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {

		
		ccp.LoginWith("csrtest", "csrtest");
		ccHome.SearchByOrderNumber("66666");
		ValidateCC.hasResult("");

		
	}

	
}
