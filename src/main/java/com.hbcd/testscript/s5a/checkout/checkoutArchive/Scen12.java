package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;

public class Scen12 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ChangeShippingMethod("Rush");
//		ValidateRs.hasShippingMethodChanged(dataObject.getSkuListInfo().get(0),"Rush"); need dynamic check
		shp.ClickCheckoutOptionalAddressConfirmation();
		shp.ClickCheckoutOptionalAddressConfirmation();
		rsp.ClickPlaceOrder();
	}
}
