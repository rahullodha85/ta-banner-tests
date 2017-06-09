package com.hbcd.testscript.lt.ltm_checkout_userstories.B16196;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateShippingAndBilling;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/23/2016.
 * L&TM: Remove Multi Address Shipping
 * S1:  Filling ship info for the first time Click here
 GIVEN I am a Lord & Taylor customer
 AND I have two or more items in my bag
 WHEN I reach Shopping & Billing page while checking out my purchase
 THEN I don't see any option to ship to multiple addresses.
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
        ValidateShippingAndBilling.isMultiAddressShippingRemoved();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();

    }
}
