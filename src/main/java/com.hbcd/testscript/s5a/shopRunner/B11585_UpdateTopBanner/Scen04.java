package com.hbcd.testscript.s5a.shopRunner.B11585_UpdateTopBanner;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen04 extends ScenarioChkout {

    public void executeScript() throws Exception {

     //    Saks Shipping Page - Update Top Banner for Mixed Items - Not Signed In

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");

    }
}
