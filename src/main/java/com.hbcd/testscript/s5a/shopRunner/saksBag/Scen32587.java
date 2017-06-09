package com.hbcd.testscript.s5a.shopRunner.saksBag;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32587 extends ScenarioChkout {

    public void executeScript() throws Exception {

      // Eligible Items- Signed In
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(3);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(2);
        pdp.EnterBag();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.bagExpressShopRunnerBtn();
        ValidateBag.bagValidateShippingMethod("ShopRunner 2 Day FREE (Est. Delivery N/A)");
        ValidateBag.bagShopRunnerSignOut();

    }
}
