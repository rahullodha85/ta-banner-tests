package com.hbcd.testscript.dr.s5a.www;

//import com.hbcd.commonbanner.base.pages.SearchFunction;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;



public class Scen33 extends ScenarioPaypal{
	
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0438336333415");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		bag.ClickPaypal();
		plog.LoginWithPaypal("testnn11@test.com", "test2013");
		pinf.continueFromPaypal();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		yap.CancelOrder(Storage.get("orderNumber"),"95131");
		ValidateYourAcc.ValidateErrorMessage("This order has been cancelled.");
	}

}