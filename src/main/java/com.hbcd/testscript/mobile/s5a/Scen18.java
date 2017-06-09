package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen18 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.CheckOut();
		
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());

		
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Hello", "World", "No Wrap");
		ValidateBag.ValidateGiftWrapPrice();
		
		rsp.ClickPlaceOrder();
		ValidateConfirmation.GiftWrap("World", dataObject.getSkuListInfo().get(0));
		
	}

}
