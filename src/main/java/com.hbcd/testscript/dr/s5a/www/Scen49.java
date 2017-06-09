package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by zakirkhan on 1/7/2016.
 */


public class Scen49 extends ScenarioSaks {

    // Validating ShopRunner Eligible Item checkout

    public void executeScript()throws Exception{

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.bagExpressShopRunnerBtn();
        ValidateBag.bagValidateShippingMethod("ShopRunner 2 Day FREE (Est. Delivery N/A)");
        Thread.sleep(2000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        Thread.sleep(2000);
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);
        Thread.sleep(2000);
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        ValidateRs.hasIconSrReviewandSubmit();
        ValidateRs.shopRunnerEligibleIcononReviewAndSubmitPage();
        ValidateRs.hasShoprunnerFreeShippingonReviewandSubmitPage();

    }

}
