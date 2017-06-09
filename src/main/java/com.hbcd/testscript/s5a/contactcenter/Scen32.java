package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen32 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {
		
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("checkoutscen03@saks.com", "test123");
		
		//change card discover 2650
		//change card master 2205
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		
		
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csrtest", "csrtest");
		ccHome.SearchByOrderNumber(Storage.get("orderNumber"));
		
		//validate payment discover

		
	}

}
