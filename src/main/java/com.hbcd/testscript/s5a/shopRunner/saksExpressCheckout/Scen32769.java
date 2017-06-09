package com.hbcd.testscript.s5a.shopRunner.saksExpressCheckout;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateShoprunnerExpresscheckoutBag;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32769 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(2);
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.clickShoprunnerExpressCheckOut();
        shr.ShopRunnerLoginWith("saks-test@shoprunner.com", "test1234");
        ValidateShoprunnerExpresscheckoutBag.returnToBagExpressCheckout();
        Thread.sleep(6000);
    }
}
