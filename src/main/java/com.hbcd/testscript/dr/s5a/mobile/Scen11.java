package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen11 extends ScenarioMobileSaks {
	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0406754977757");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("dr"+Common.getUniqueNumber()+"@s5a.com");
		shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true);
		pap.AddNewCreditCard(0);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
		cop.CancelOrder();
		
}
}