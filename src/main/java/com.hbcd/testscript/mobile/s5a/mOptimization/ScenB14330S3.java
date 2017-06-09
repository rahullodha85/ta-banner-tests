package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Saks Bag-User removed all the item should display 0 items in bag
 * B14330 contains the scenarios of S3 and S4
 */
public class ScenB14330S3 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.Remove(item1);
        ValidateBag.hasBagDisplayedwithNumbersOfItem("0");
        ValidateBag.hasTextWithNoItemsInBag();
    }
}
