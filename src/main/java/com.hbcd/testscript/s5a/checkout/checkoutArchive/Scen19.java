package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1); // 3 quantity
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation1", "test123");;
		ValidateRs.isGift(dataObject.getSkuListInfo().get(0));
		rsp.ClickPlaceOrder();
		ValidateRs.isGift(dataObject.getSkuListInfo().get(0));
	}
}
