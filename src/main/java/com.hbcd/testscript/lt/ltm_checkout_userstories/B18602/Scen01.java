package com.hbcd.testscript.lt.ltm_checkout_userstories.B18602;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateReviewAndSubmitPage;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 10/18/2016.
 * B-18602
 * L&TM: Signature Required
 *  As a domestic customer, my package does not require a signature
 GIVEN I am a Lord and Taylor customer
 AND i am checking out an order and none of the products require signature
 WHEN I reach Review and Submit page
 THEN I don't see that a signature will be required by the time of delivery
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        ValidateReviewAndSubmitPage.isSignatureNotRequired();
    }
}
