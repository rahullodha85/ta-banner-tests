package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen21 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(2)); // PRE ORDER ITEM
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.isPreOrderItemInCart(dataObject.getSkuListInfo().get(2)); //dynamic check
		rsp.ClickPlaceOrder();
//		ValidateRs.isPreOrderItemInCart(dataObject.getSkuListInfo().get(2));
	}
}
