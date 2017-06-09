package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen32 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("claudiasosa" + Common.getUniqueNumber() + "@s5a.com");
		shp.AddShippingAddress(true, "12 E 49th Street", "New York",
				"New York", "10017", true);
		pap.AddNewCreditCard(3);
		rsp.AddShippingAddress("12 E 49th street", "New York", "New York", "10017", false);
//		rsp.ClickPlaceOrder();
//		cop.EnterPassword("test", "test123");
//		ValidateConfirmation.hasInvalidPasswordError();
//		cop.EnterPassword("test123", "test1234");
//		ValidateConfirmation.hasPasswordDoesnotMatchError();
//		cop.EnterPassword("test123", "test123");
		
	}
}