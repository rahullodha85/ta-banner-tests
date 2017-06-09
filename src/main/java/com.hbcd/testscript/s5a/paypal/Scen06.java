package com.hbcd.testscript.s5a.paypal;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen06 extends ScenarioPaypal{
	@Override
	public void executeScript() throws Exception {
		String item1 = itemData.get(ItemType.REGULAR);
		
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal();
		plog.LoginWithPaypal("testnn12@test.com", "test2013");
		pinf.continueFromPaypal();
		ValidateRs.isVegc(item1);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		
	}

}
