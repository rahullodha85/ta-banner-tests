package com.hbcd.testscript.lt.ltm_checkout_userstories.B16566;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateConfirmationPage;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/24/2016.
 * L&TM: Remove 'Cancel Order' Button on Thank You Page
 * S1: There is no "Cancel Order Placed..." button on the Thank You page
 GIVEN There is no remose period for L&T
 WHEN A customer places an order
 THEN They will be taken to the Thank You page
 AND They will not see a "Cancel Order Placed" button
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
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
        ValidateConfirmationPage.isCancelButtonRemoved(); //Used for Feature Gap/Stories for LT

    }
}
