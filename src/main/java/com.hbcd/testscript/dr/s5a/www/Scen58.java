package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateMyAccountPage;
import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.base.ScenarioSaks;

public class Scen58 extends ScenarioSaks{

	/**
	 **Registered user log in into account
	 *Update shipping and billing address, enter a new credit card. Click on every link in Sign In drop-down
	 *
	 * * "Welcome, [Name]"  greetings displays in the top nav
	 * Shopper should be redirected to the respective account page associated with the link clicked on the Sign In drop-down.
	 */

	@Override
	public void executeScript() throws Exception {
		yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateMyAccountPage.checkIfUserSignedIn("willis"); // name will correspond with login
	}
}
