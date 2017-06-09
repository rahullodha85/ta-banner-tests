package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 901124 on 12/19/16.
 * Validate "masterpass" is added as a payment_service property of the user's credit cards
 * when that credit card is being accessed from a Masterpass Wallet
 */
public class ScenWAT49 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
        ValidatePap.hasPaymentMethod("Masterpass");
    }
}