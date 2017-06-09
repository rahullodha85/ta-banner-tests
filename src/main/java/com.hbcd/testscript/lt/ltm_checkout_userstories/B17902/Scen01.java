package com.hbcd.testscript.lt.ltm_checkout_userstories.B17902;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidatePaymentPage;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 8/25/2016.
 * L&TM: L&T forms of payment
 * S1: Payment checkout page
 GIVEN I am a Lord & Taylor Customer
 WHEN I am at Payment checkout page
 THEN I see Lord & Taylor, Discover, Mastercard, VISA, AMEX and Paypal forms of payment at payment type dropdown menu
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.EnterPaymentDetails("Lord & Taylor", "6002922600000533", "Christopher Reynolds");
        ValidatePaymentPage.isFormsOfPaymentSelectedFromDropDown("Lord & Taylor", "6002922600000533");
        pap.EnterPaymentDetails("Discover", "6011111111111117", "Christopher Reynolds" );
        ValidatePaymentPage.isFormsOfPaymentSelectedFromDropDown("Discover", "6011111111111117");
        pap.EnterPaymentDetails("MasterCard", "5105105105105100", "Christopher Reynolds");
        ValidatePaymentPage.isFormsOfPaymentSelectedFromDropDown("MasterCard", "5105105105105100");
        pap.EnterPaymentDetails("Visa", "4111111111111111", "Christopher Reynolds" );
        ValidatePaymentPage.isFormsOfPaymentSelectedFromDropDown("Visa", "4111111111111111");
        pap.EnterPaymentDetails("American Express", "371449635398431", "Christopher Reynolds");
        ValidatePaymentPage.isFormsOfPaymentSelectedFromDropDown("American Express", "371449635398431");



    }
}
