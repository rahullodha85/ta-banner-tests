package com.hbcd.testscript.s5a.shopRunner.saksPayment;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32707 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(2);
        Thread.sleep(4000);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(5000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        shp.AddShippingAddress(false, "250 Vesey  street", "New York", "New York", "10281", true);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateShippingBilling.shipAndBillShopRunnerIneligibleIconNotDisplay();

    }
}
