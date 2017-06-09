package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Saks Bag-product info
 */
public class ScenB14376S1 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.isProductBrandNamePresent();
        ValidateBag.isProductNamePresent();
        ValidateBag.isProductIdPresent();
        ValidateBag.isColorAndSizePresent();



    }
}
