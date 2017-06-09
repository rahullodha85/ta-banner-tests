package com.hbcd.testscript.mobile.s5a;


import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen41 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("claudiasosa"+Common.getUniqueNumber()+"@s5a.com");
		shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true);
		pap.AddNewCreditCard(3,"test123","test123");
		ValidateRs.ShippingCharges("Standard");
		rsp.ChangeShippingMethod("Rush");
		ValidateRs.ShippingCharges("Rush");
		rsp.ChangeShippingMethod("Next Bus");
		ValidateRs.ShippingCharges("Next Bus");
		rsp.ChangeShippingMethod("Saturday");
		ValidateRs.ShippingCharges("Saturday");
		ValidateRs.EstimatedDeliveryDate();
}
}