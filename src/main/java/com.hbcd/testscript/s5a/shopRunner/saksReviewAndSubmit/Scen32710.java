package com.hbcd.testscript.s5a.shopRunner.saksReviewAndSubmit;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32710 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        Thread.sleep(2000);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagExpressShopRunnerBtn();
        Thread.sleep(2000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        Thread.sleep(2000);
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        ValidateRs.hasIconSrReviewandSubmit();
        ValidateRs.shopRunnerEligibleIcononReviewAndSubmitPage();
        ValidateRs.standardShippingNotLoggedIn();
        Thread.sleep(2000);
    }
}
