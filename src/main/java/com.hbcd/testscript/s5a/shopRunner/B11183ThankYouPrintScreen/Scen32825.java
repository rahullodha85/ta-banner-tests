package com.hbcd.testscript.s5a.shopRunner.B11183ThankYouPrintScreen;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.validations.s5a.*;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;


public class Scen32825 extends ScenarioChkout {

    public void executeScript() throws Exception {

        //  On the Thank You page, eligible item purchased - not signed in user

        String item1 = dataObject.getSkuListInfo().get(0);

        nav.SearchFor(item1);
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(true, "12 E 49 street", "New York", "New York", "10017", true);
        pap.AddNewCreditCard(3);//mastercard
        ValidateReviewSubmit.isShopRunnerEligibleSignDisplay();
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.hasShopRunnerEligibleSign("0402284270900");
        ValidateConfirmation.ShippingMethod("Standard", item1);

    }
}


