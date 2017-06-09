package com.hbcd.testscript.lt.ltm_checkout_userstories.B16012;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/29/2016.
 * B16012
 * L&TM: Disable ShopRunner Express Checkout
 * S1: Express Checkout is not available to ShopRunner members on L&T
 GIVEN I have a ShopRunner eligible and/or ineligible item in my bag
 WHEN I open the Bag screen
 THEN I will not see the ShopRunner Express Checkout button
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBagPage.isExpressCheckOutBtnRemoved();
    }
}
