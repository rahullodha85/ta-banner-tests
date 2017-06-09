package com.hbcd.testscript.s5a.shopRunner.saksExpressCheckout;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateLl;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen32770 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
        yap.GoToMyAcccount();
        yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
        yap.clickSaksFifthLogo();
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(2);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        Thread.sleep(3000);
        ValidateBag.topBannerShopRunnerSigninlearnMore();




    }
}
