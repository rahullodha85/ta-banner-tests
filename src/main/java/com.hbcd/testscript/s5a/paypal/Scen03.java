package com.hbcd.testscript.s5a.paypal;

import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen03 extends ScenarioPaypal{
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal();
		plog.LoginWithPaypal(" su_1342452955_per@s5a.com", "test2012");
		pinf.continueFromPaypal();
		rsp.ApplyGiftCard("6015990000350480", "5863");
	}
}
