package com.hbcd.testscript.s5a.shopRunner.saksReviewAndSubmit;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32712 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagExpressShopRunnerBtn();
        Thread.sleep(2000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        Thread.sleep(3000);
        ValidateRs.hasIconSrReviewandSubmit();
        ValidateRs.restrictedShippingMethodFirIneligible();
    }
}
