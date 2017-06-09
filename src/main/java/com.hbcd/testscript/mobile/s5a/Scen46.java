package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen46 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {


		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		String item3 = dataObject.getSkuListInfo().get(2);
		
		nav.SearchFor(item1);

		pdp.AddToBag("", 3);
		pdp.EnterBag();
		ValidatePdp.bagCount("3");
		ValidateBag.isItemPresentInBag(item1);
		ValidateBag.hasBrandName(item2);
		ValidateBag.hasSPD(item3);
		ValidateBag.hasQuantity(item1, "3");
		ValidateBag.hasPayPalButton();
		ValidateBag.hasMakeThisGift(item1);
		ValidateBag.hasEditSizeColorQtyLink(item1);
		ValidateBag.bagCount("3");
		bag.Remove(item1);
		ValidateBag.ItemNOTPresentInBag(item1);

}

}
