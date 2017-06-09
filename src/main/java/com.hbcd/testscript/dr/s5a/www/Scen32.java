package com.hbcd.testscript.dr.s5a.www;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

import java.util.Date;


public class Scen32 extends ScenarioPaypal {
	
	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0438336333415");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo("LAMER87");
		bag.CheckOut();
		bag.ClickPaypal();
		plog.LoginWithPaypal("testnn11@test.com", "test2013");
		pinf.continueFromPaypal();
		//Validate Paypal
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		String timeStamp = Long.toString(new Date().getTime());
		String varOrderNumber = "Order_Number_" + timeStamp;
		Storage.save(varOrderNumber, ValidateConfirmation.getOrderNumber());
		yap.CancelOrder(Storage.get(varOrderNumber),"95131");
		ValidateYourAcc.ValidateErrorMessage("This order has been cancelled.");
	}

}