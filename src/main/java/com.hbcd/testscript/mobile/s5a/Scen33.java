package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen33 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {
		String regularItem1=itemData.get(ItemType.DROPSHIP);
		String dropshipItem1 = itemData.get(ItemType.DROPSHIP);
		String dropshipItem2 = itemData.get(ItemType.DROPSHIP);

		nav.SearchFor(regularItem1);
		pdp.AddToBag(2);
		
		nav.SearchFor(dropshipItem1);
		pdp.AddToBag(1);
		
		nav.SearchFor(dropshipItem2);
		pdp.AddToBag(1);
		
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith("testc1@test.com", "123456ab");
		
		ValidateRs.UpgradeShippingMessage();
		
		rsp.ClickShippingMethodToolTip(dropshipItem2);
		
		ValidateRs.ToolTipShippingRestrictionMsg(dropshipItem2);
		
		
		
		
		
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
		

	}

}