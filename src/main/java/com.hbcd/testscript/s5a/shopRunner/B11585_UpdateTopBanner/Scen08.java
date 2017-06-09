package com.hbcd.testscript.s5a.shopRunner.B11585_UpdateTopBanner;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen08 extends ScenarioChkout {

    public void executeScript() throws Exception {

     //    Saks Review and Submite Page - Update Top Banner for Mixed Items - Not Signed In

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
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateRs.shopRunnerEligibleIcononReviewAndSubmitPage();

    }
}
