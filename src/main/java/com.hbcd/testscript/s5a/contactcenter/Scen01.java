package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

//import com.hbcd.scripting.core.Navigate;

public class Scen01 extends ScenarioCC {
	public void executeScript() throws Exception {

		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo("Holiday7");
		bag.ClickCheckout().LoginWith("vautomation@saks.com", "qwerty1");
		rsp.ClickPlaceOrder();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		Navigate.go(Storage.get("Saks_CC_URL"));
		cc.LoginWith("csrtest", "csrtest");
		cc.SearchOrder(Storage.get("orderNumber"));
		
	}
}
