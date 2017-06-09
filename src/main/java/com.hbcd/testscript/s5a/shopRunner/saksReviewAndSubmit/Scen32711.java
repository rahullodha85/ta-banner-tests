package com.hbcd.testscript.s5a.shopRunner.saksReviewAndSubmit;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32711 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(2));
        Thread.sleep(2000);
        ValidatePdp.hasShoprunner();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(2000);
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.bagExpressShopRunnerBtn();
        Thread.sleep(2000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        Thread.sleep(2000);
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        ValidateRs.hasIconSrReviewandSubmit();
        Thread.sleep(2000);
        ValidateRs.restrictedShippingMethodFirIneligible();
    }
}
