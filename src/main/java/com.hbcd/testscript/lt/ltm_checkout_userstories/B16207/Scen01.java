package com.hbcd.testscript.lt.ltm_checkout_userstories.B16207;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateReviewAndSubmitPage;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/23/2016.
 * L&TM: Remove Signature Required
 * S1: Review and Submit page Click here.
 GIVEN I am a Lord & Taylor Customer
 WHEN I reach Review & Submit page while checking out my purchase
 THEN I don't see any option to make a signature as mandatory during delivery
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
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        ValidateReviewAndSubmitPage.isSignatureRemoved();
        rsp.ClickPlaceOrder();


    }

}
