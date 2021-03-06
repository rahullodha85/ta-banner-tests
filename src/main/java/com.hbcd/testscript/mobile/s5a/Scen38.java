package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen38 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

	nav.SearchFor(dataObject.getSkuListInfo().get(0));
	pdp.AddToBag(1);
	pdp.EnterBag();
	bag.CheckOut();
	lgn.LoginWith("claudiasosa"+Common.getUniqueNumber()+"@s5a.com");
	shp.AddShippingAddress(true, "P.O. Box 1965", "California", "Rancho Santa Fe", "92067", true);
	pap.AddNewCreditCard(3,"test123","test123");
	ValidateRs.ShippingMethod(dataObject.getSkuListInfo().get(0), "Standard");
//	rsp.ClickPlaceOrder();
//	ValidateConfirmation.hasOrderNumber();
}
}