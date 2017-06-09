package com.hbcd.testscript.lt.ltm_checkout_userstories.B17440;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 9/7/2016.
 *  B-17440
 *  L&TM: Authorize Multi-Tender Payments (CC & Gift Card)
 *  S1: As a domestic customer, I place an order with a gift card and a credit card
 GIVEN I have a balance on my gift card
 AND I'm using a valid Visa card
 WHEN I place my order with both tender types
 THEN My order will be placed
 AND The balance will be deducted from my gift card
 AND My Visa card will be charged for the remainder
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.EnterQuantity(4);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddGiftcard("2293774218","1009"); //Adding the GiftCard for LT
        pap.AddNewCreditCard(4); //Using the Visa Card
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
    }
}
