package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen30 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
//		nav.SearchFor("0424955999378");
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("sukhbirwalia33@yahoo.com");
		shp.AddShippingAddress(false, "12 east 49 st", "New York", "New York", "10017", false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csr_agent", "csr_agent");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip(Storage.get("orderNumber"), "");
		//cancel  order
		
	}
}
