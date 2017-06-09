package com.hbcd.testscript.s5a.shopRunner.saksBag;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32703 extends ScenarioChkout {

    public void executeScript() throws Exception {
        //Chanel items
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.selectSizeSwatch("1.7 OZ.");
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(4000);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        Thread.sleep(2000);
        ValidateBag.bagExpressShopRunnerBtn();
        Thread.sleep(3000);
        ValidateBag.bagShopRunnerSignOut();

    }
}
