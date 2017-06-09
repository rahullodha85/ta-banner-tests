package com.hbcd.testscript.s5a.shopRunner.SaksShippingAndBilling;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32700 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(1000);
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        ValidatePdp.hasShoprunner();
        Thread.sleep(2000);
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        Thread.sleep(2000);
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        ValidateBag.topBannerShopRunnerSigninlearnMore();


    }
}
