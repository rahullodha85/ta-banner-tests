package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen02 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);

		nav.SearchFor(item1);
		pdp.AddToBag(4);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
}
}
