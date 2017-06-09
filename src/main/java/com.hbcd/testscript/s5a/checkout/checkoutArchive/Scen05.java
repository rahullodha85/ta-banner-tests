package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.MakeGift(dataObject.getSkuListInfo().get(1)).With("Automation", "Logo");
		bag.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation1", "Logo1");
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.isGift(dataObject.getSkuListInfo().get(1)); //need to add dynamic object check
//		ValidateRs.isGift(dataObject.getSkuListInfo().get(0));
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}

}
