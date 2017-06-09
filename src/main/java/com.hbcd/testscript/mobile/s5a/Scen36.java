package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;
import com.hbcd.utility.helper.Common;

public class Scen36 extends ScenarioMobileSaks{

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
		
		nav.SearchFor("0400087123573");
		pdp.AddToBag(1);
		
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("claudiasosa"+Common.getUniqueNumber()+"@s5a.com");
		shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true);
		pap.AddNewCreditCard(3,"test123","test123");
		ValidateRs.ShippingRestrictionMessage();
		ValidateRs.ShippingMethodSpeedAndCost("Next Bus");
		ValidateRs.ShippingMethodSpeedAndCost("Saturday");
		rsp.ClickPlaceOrder();
		
		
}
}
