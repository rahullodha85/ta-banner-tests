package com.hbcd.testscript.s5a.o5mDeltaStories.bogos;

import com.hbcd.banner.validations.s5a.*;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 4/6/2016.
 * B12967:Display of BOGOs- Review Page
 */
public class ScenB12967 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(1000);
        pdp.EnterQuantity(2);
        pdp.AddToBag();
        pdp.EnterBag();
        Thread.sleep(1000);
        ValidateBag.hasBuyOneGetOnePromoDisplayed("BUY 1 G 1 FREE");
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        ValidateShippingBilling.isBuyOneGetOneMessagePresent("BUY 1 G 1 FREE");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        ValidatePymt.hasBuyOneGetOnePromoOnPaymentPage("BUY 1 G 1 FREE");
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        ValidateReviewSubmit.hasBuyOneGetOnePromoOnRs("BUY 1 G 1 FREE");
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
        ValidateConfirmation.hasBuyOneGetOnePromoPresent("BUY 1 GET 1 FREE");

    }
}
