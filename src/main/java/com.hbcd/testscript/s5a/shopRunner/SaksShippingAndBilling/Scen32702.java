package com.hbcd.testscript.s5a.shopRunner.SaksShippingAndBilling;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32702 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
        //Add two ineligible items (steaks) which have no shopRunner icons
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        Thread.sleep(1000);
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateShippingBilling.shipAndBillShopRunnerIneligibleIconNotDisplay();



    }
}
