package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen50 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0419024843133");
        ValidatePdp.hasShoprunner();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith("anne_bacay@s5a.com", "qatest123");
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.bagExpressShopRunnerBtn();
    }
}
