package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Mobile Web - Saks bag - Edit quantity
 */
public class ScenB14363 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.SelectBagItemQuantity(item1,2);

    }
}
