package com.hbcd.testscript.s5a.shopRunner.SaksShippingAndBilling;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32699 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(1000);
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        Thread.sleep(2000);
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(2000);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        Thread.sleep(1000);
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        Thread.sleep(2000);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerSignOut();
        Thread.sleep(1000);
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        ValidateBag.topBannerShopRunnerSigninlearnMore();

    }


}
