package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen23 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.MakeGift(item1).With("Hello", "World", "no wrap");
		ValidateBag.ValidateGiftWrapPrice();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.GiftWrap("no wrap", item1);
	}

}
