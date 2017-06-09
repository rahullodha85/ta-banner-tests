package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;

public class Scen13 extends ScenarioChkout {
	public void executeScript() throws Exception {
		
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo(dataObject.getPromoList().get(0));
		bag.ApplyPromo(dataObject.getPromoList().get(1));
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.EditShippingAddress(dataObject.getAddress1());
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		rsp.ClickPlaceOrder();
	}
}
