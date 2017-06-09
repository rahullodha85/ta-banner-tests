package com.hbcd.testscript.s5a.checkout.productionCheckout;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen01 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout();
		rsp.ClearAllItemsInBag();
		
		
	}

}
