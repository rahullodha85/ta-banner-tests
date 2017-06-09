package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen34 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		String dropshipItem1 = itemData.get(ItemType.DROPSHIP);
		String dropshipItem2 = itemData.get(ItemType.DROPSHIP);
	
		nav.SearchFor("0438386556826");
		pdp.AddToBag(4);
		
		nav.SearchFor(dropshipItem1);
		pdp.AddToBag(1);
		
		nav.SearchFor(dropshipItem2);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("qaengineer@s5a.com", "test123");
		ValidateRs.ShippingMethodSpeedAndCost("Next Bus");
		ValidateRs.ShippingMethodSpeedAndCost("Saturday");
		rsp.ClickPlaceOrder();
		
		
}
}
