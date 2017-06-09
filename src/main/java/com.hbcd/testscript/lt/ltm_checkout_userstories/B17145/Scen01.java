package com.hbcd.testscript.lt.ltm_checkout_userstories.B17145;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateProductDetailPage;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/1/2016.
 * Shoprunner Eligible Item on PDP
 */
public class Scen01 extends ScenarioCommonPlatform{
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidateProductDetailPage.isUserOnProductDetailPage();
        ValidateProductDetailPage.isItemShopRunnerEligible();
    }
}
