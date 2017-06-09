package com.hbcd.testscript.s5a.shopRunner.B11183ThankYouPrintScreen;

import com.hbcd.banner.validations.s5a.*;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen32828 extends ScenarioChkout {

    public void executeScript() throws Exception {

        //   On the Print Screen page, ineligible item purchased - signed in user

        String item1 = dataObject.getSkuListInfo().get(0);

        nav.SearchFor(item1);
        ValidatePdp.hasNoShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleSignNotDisplay("Eligible");
        shp.AddShippingAddress(true, "12 E 49 street", "New York", "New York", "10017", true);
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        ValidateReviewSubmit.isShopRunnerEligibleSignNotDisplay("0457142487549");
        rsp.ClickPlaceOrder();
        ValidateConfirmation.hasNoShopRunnerEligibleSign();
        ValidateConfirmation.ShippingMethod("Standard", item1);
        conf.ClickPrintReceipt();
        ValidateThankYou.ShippingMethod("Standard", item1);
        ValidateThankYou.hasNoShopRunnerEligibleSign();

    }
}
