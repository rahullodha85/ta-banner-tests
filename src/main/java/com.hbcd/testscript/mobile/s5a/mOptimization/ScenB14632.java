package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Saks Bag - Empty Shopping Bag
 * B14632
 */
public class ScenB14632 extends ScenarioMobileSaks {
    @Override
    public void executeScript() throws Exception {
        ValidateBag.hasNoItemsInSaksBag("0");
    }
}
