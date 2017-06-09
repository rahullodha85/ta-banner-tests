package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

/**
 * Created by 901124 on 3/1/2016.
 */
public class ScenB14622 extends ScenarioMobileSaks {

    /**/
    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.EstimatedTotalDisplaysWithDollarSign();
        ValidateBag.EstimatedTotalHasCommaAtThousandthDigit();
        ValidateBag.hasEstimatedTotalOnTopOfPage();
        ValidateBag.hasEstimatedBottomOnTopOfPage();
        ValidateBag.hasShoprunnerBanner();
        ValidateBag.hasPayPalButton();

    }
}