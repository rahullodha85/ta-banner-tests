package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen22 extends ScenarioChkout {
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.EditCreditCard("Hello World");
		rsp.ClickPlaceOrder();
//		ValidateConfirmation.validateCreditCard("Hello World", "222");
	}
}
