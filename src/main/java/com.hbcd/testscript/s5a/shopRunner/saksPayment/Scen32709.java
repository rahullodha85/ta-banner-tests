package com.hbcd.testscript.s5a.shopRunner.saksPayment;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32709 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        //Chanel items
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.selectSizeSwatch("1.7 OZ.");
        pdp.AddToBag(2);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.selectSizeSwatch("1.2 OZ");
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateShippingBilling.shipAndBillShopRunnerIneligibleIconNotDisplay();
    }


    }
