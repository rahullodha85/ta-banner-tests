package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen18 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {
		// need edit payment situation
		
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0457140933284");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("cccheckoutscen18@saks.com", "test123");
		rsp.EditCreditCard("Hello World", "Saks Fifth Avenue Store Card", "7528294270");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		
		Navigate.go(Storage.get("Saks_CC_URL"));
		
		ccp.LoginWith("csr_agent", "csr_agent");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip(Storage.get("orderNumber"), "");
		ValidateCC.checkStatus("Hold - Risk");
		ccOrders.ClickEditPaymentInformation();
		ccOrders.RemoveCreditCard();
		ccOrders.AddCreditCard("saks");
		
		
		
	}

}
