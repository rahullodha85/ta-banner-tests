package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen04 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(2));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(3));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.Remove(dataObject.getSkuListInfo().get(3));
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.Remove(dataObject.getSkuListInfo().get(0));
		Thread.sleep(3000L);
		rsp.UpdateQuantity(dataObject.getSkuListInfo().get(1),"4");
		Thread.sleep(3000L);
		rsp.UpdateQuantity(dataObject.getSkuListInfo().get(2),"4");
		Thread.sleep(3000L);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.validateQuantity(dataObject.getSkuListInfo().get(1),"4");
		ValidateConfirmation.validateQuantity(dataObject.getSkuListInfo().get(2),"4");
		
	}

}
