package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

/**
 * Created by 901124 on 3/3/2016.
 */
public class Scen14708_S1 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        String item2 = dataObject.getSkuListInfo().get(1);

        nav.SearchFor(item1);
        pdp.AddToBag(1);
        nav.SearchFor(item2);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.Remove(item1);
        bag.Remove(item2);
        ValidateBag.itemNotInBag(item1);
    }
}