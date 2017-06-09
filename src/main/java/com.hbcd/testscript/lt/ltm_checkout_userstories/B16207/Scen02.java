package com.hbcd.testscript.lt.ltm_checkout_userstories.B16207;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateReviewAndSubmitPage;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/23/2016.
 * L&TM: Remove Signature Required
 *S2: Editing Shpping Method Click Here.
 GIVEN I am a Lord & Taylor Customer
 AND I have already choosen shipping method option
 WHEN I try to edit shipping method
 THEN I don't see any option to make a signature as mandatory during delivery
 */
public class Scen02 extends ScenarioCommonPlatform {

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
        ValidateReviewAndSubmitPage.isSignatureRequiredForShippingMethods("Rush");
        ValidateReviewAndSubmitPage.isSignatureRemoved();


    }


}
