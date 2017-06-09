package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen06 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {

		// need edit payment situation
		
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0457140933284");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("cccheckoutscen06@saks.com", "test123");
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		ValidateConfirmation.isThankYouPage();
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csr_agent", "csr_agent");
		ccHome.SearchByOrderNumber(Storage.get("orderNumber"));
		ValidateCC.hasResult(Storage.get("orderNumber"));
	    ValidateCC.checkStatus("Hold - Risk");
       // ccOrders.ClickEditPaymentInformation();
       //ccOrders.RemoveCreditCard();
	   //ccOrders.AddCreditCard("Master");
	}

}
