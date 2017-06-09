package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Service;


public class Scen02 extends ScenarioChkout {

	
	public void executeScript() throws Exception {
//		if (
//				!Service.isAvaliable(dataObject.getSkuListInfo().get(0)) ||
//				!Service.isAvaliable(dataObject.getSkuListInfo().get(1))
//			)
//		{
//			throw new Exception("Data is Not Available");
//		}
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.FreeShipping();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}