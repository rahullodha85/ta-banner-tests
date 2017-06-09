package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen23 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickShippingAndBillingTab();
		shp.ClickEditShippingAddress();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
		shp.ClickEditBillingAddress();
		shp.AddBillingAddress(dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
		pap.ClickCheckout();
		
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		ValidateRs.BillingAddressContains(dataObject.getAddress1());
		
		rsp.ClickPlaceOrder();
		
		ValidateConfirmation.BillingAddressContains(dataObject.getAddress1());
		ValidateConfirmation.ShippingAddressContains(dataObject.getAddress1());
	}
}
