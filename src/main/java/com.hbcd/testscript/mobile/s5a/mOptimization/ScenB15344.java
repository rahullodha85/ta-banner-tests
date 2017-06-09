package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Mobile Web - Saks Bag - Alert
 * B15344
 */
public class ScenB15344  extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.hasAlertMessageOnBag("You will be able to apply promotional codes and gift cards to your order after you proceed to Checkout.");
    }
}
