package com.hbcd.testscript.s5a.shopRunner.B11585_UpdateTopBanner;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioChkout {

    public void executeScript() throws Exception {

     //    Saks Payment Page - Update Top Banner for Mixed Items - Signed In

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");

    }
}
