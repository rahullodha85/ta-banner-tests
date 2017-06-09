package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;

public class Scen10 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.EditShippingAddress(dataObject.getAddress1());
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		shp.ClickCheckoutOptionalAddressConfirmation();
		shp.ClickCheckoutOptionalAddressConfirmation();
		rsp.ClickPlaceOrder();
	}
}
