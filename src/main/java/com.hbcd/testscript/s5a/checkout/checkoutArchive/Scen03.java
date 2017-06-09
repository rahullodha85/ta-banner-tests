package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen03 extends ScenarioChkout {

	
	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.FreeShipping();

		rsp.ClickPlaceOrder();
		
	}

	
}