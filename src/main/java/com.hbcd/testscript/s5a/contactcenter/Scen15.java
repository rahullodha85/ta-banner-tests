package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.core.Switch;

public class Scen15 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {

		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickCreateOrder();
		
		//happy path code from saks
		Switch.toNewWindow("Designer");
		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginThruCC("checkoutscen03@saks.com");
 		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());

		Switch.toNewWindow("Contact Center");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip(Storage.get("orderNumber"), "");
		ValidateCC.hasOrderInformation();
		ccOrders.AccessPdp("0476703126079");
		ValidateCC.hasProductDetails("0476703126079");
		
	}

}
