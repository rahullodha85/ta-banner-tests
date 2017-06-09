package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioChkout {


	public void executeScript() throws Exception {
		
		nav.SearchFor("0427915085753");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo(dataObject.getPromo());
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
				dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
	}
}
