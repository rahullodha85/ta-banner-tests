package com.hbcd.testscript.s5a.shopRunner.saksBag;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen32588 extends ScenarioChkout {

    public void executeScript() throws Exception {

        // Eligible Items- Not Signed In
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(3);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(4000);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        Thread.sleep(8000);
        ValidateBag.bagValidateShippingMethod("ShopRunner 2 Day FREE (Est. Delivery N/A)");
        Thread.sleep(8000);
    }
}

