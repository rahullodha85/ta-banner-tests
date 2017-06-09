package com.hbcd.testscript.lt.syntheticMonitoring;

import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 2/3/2017.
 */
public class Scen_SyncMonitoring extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor("");
        prp.ClickFirstItem();
        pdp.AddToBag(1);
        miniBagOverlay.clickCheckout();
        bag.ClickCheckout().ClickGuestCheckout();
        ValidateShippingBilling.hasUserlandedOnShippingAndBilling("Shipping & Billing");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
    }
}
