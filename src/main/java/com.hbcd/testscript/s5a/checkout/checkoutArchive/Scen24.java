package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;

public class Scen24 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.EditShippingAddress(dataObject.getAddress1());
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		Alert.Confirm();
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout();
		ValidateRs.isItemPresent(dataObject.getSkuListInfo().get(1));
		rsp.ClickPlaceOrder();
	}
}
