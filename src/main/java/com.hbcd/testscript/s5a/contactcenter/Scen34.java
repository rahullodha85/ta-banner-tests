package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen34 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {
		
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0438306822833");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("sukhbirwalia33@yahoo.com");
		shp.AddShippingAddress(false, "12 east 49 st", "New York", "New York", "10017", false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
//		
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csr_agent", "csr_agent");
		ccNav.ClickOrders();
//		ccOrders.SearchByOrderNumberAndZip(Storage.get("orderNumber"), "10017");
		ccOrders.SearchByOrderNumberAndZip(Storage.get("orderNumber"), "");
		//not yet written confusion with storetwosearch
		ValidateCC.hasStoreFlagSet();

		
	}

}
