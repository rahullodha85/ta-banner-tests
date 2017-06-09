package com.hbcd.testscript.s5a.masterpass;


import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by nithajomy on 1/9/2017.
 * WAT-66-Masterpass- Masterpass is shown as a method of payment in the dropdown even when the toggle is OFF

  */
public class ScenWAT66 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
         pdp.EnterBag();
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
        ValidatePap.hasNoPaymentMethod("masterpass");
    }
}
