package com.hbcd.testscript.mobile.s5a;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen17 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.Remove(dataObject.getSkuListInfo().get(1));
		bag.CheckOut();
}
}