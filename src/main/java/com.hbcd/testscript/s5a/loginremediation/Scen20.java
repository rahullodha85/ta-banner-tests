package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen20 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0400087574824");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		yap.Go();
		ValidateYourAcc.ValidateLink("ORDER HISTORY");
		ValidateYourAcc.ValidateLink("ACCOUNT AND EMAIL SETTINGS");
		ValidateYourAcc.ValidateLink("SHIPPING ADDRESS BOOK");
		ValidateYourAcc.ValidateLink("BILLING ADDRESS BOOK");
		ValidateYourAcc.ValidateLink("PAYMENT METHOD");
		ValidateYourAcc.ValidateLink("ONLINE BILLING FOR SAKS CREDIT CARD HOLDERS");
		
		
	}

}
