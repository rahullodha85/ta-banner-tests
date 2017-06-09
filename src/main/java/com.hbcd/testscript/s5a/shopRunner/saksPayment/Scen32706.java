package com.hbcd.testscript.s5a.shopRunner.saksPayment;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32706 extends ScenarioChkout{

    // Eligible Items- Not Signed In
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(3);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(2);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        shp.AddShippingAddress(false, "250 Vesey  street", "New York", "New York", "10281", true);
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");

    }
}
