package com.hbcd.testscript.s5a.shopRunner.saksReviewAndSubmit;


import com.hbcd.banner.mobile.saks.validations.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32713 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.selectSizeSwatch("1.7 OZ.");
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.selectSizeSwatch("1.2 OZ");
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        Thread.sleep(1000);
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith("saks-test@shoprunner.com", "test1234");
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        Thread.sleep(2000);
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        Thread.sleep(3000);
        ValidateRs.hasIconSrReviewandSubmit();
        ValidateRs.hasShoprunnerFreeShippingonReviewandSubmitPage();




    }


}
