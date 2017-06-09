package com.hbcd.testscript.s5a.shopRunner.saksExpressCheckout;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShoprunnerExpresscheckoutBag;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32768 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(2);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.clickShoprunnerExpressCheckOut();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(5000);
        ValidateShoprunnerExpresscheckoutBag.hasIteminShoprunnerExpressCheckoutBag();
        ValidateShoprunnerExpresscheckoutBag.hasTwodayFreeShippingPresentforExpressCheckout();
        ValidateShoprunnerExpresscheckoutBag.estimatedSalesTaxCalculated();
        ValidateShoprunnerExpresscheckoutBag.shiptoExpressCheckout();
        ValidateShoprunnerExpresscheckoutBag.payWithExpressCheckout();
        Thread.sleep(5000);
        //ValidateShoprunnerExpresscheckoutBag.thankyouConfirmationPage();


    }


}
