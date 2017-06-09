package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen23 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item1 = itemData.get(ItemType.REGULAR);
		
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickShippingAndBillingTab();
		shp.ClickEditShippingAddress();
		shp.EditShippingAddress("", "", dataObject.getAddress1(), "", dataObject.getCity(), "", dataObject.getState(), dataObject.getZipCode(), "", "", "", "");
//		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
		shp.ClickEditBillingAddress();
		shp.AddBillingAddress(dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
		pap.ClickCheckout();
		
		pap.ClickCheckout();
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		ValidateRs.BillingAddressContains(dataObject.getAddress1());
		rsp.ClickPlaceOrder();
		
		ValidateConfirmation.BillingAddressContains(dataObject.getAddress1());
		ValidateConfirmation.ShippingAddressContains(dataObject.getAddress1());
	}
}
