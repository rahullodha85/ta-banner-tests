package com.hbcd.testscript.lt.ltm_checkout_userstories.B17210;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;

/**
 * Created by aalfaruk on 7/1/2016.
 * S4: As a domestic customer, I want a SATURDAY delivery
 */
public class Scen01_S4 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        shp.SelectShippingMethodFor(dataObject.getSkuListInfo().get(0), ShipMethod.SATURDAY);
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
    }
}