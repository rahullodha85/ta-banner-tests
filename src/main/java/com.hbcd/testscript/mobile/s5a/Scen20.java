package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen20 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ChangeShippingAddress("3033 Shore Pkwy");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankyouPage();
		
	}

	

}
