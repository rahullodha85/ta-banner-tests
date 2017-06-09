package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen22 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.UpdateQuantity(item1, "2");
		ValidateBag.ValidateSubTotal(item1);
		bag.CheckOut();

	}

}
