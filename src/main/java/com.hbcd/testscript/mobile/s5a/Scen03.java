package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen03 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);

		nav.SearchFor(item1);
		pdp.AddToBag(2);

		nav.SearchFor(item2);
		pdp.AddToBag(2);

		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.UpgradeShippingMessage();
		ValidateRs.ShippingMethod(item2,"Standard");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
	}
}
