package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateYap;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Switch;

public class Scen16 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {

		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickMyAccount();
		Switch.toNewWindow("Saks.com");
		yap.Login("contact_center@s5a.com");
		ValidateYap.isDisplayed();

		
	}

}
