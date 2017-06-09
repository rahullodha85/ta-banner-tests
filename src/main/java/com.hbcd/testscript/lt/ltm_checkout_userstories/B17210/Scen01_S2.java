package com.hbcd.testscript.lt.ltm_checkout_userstories.B17210;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;

/**
 * Created by aalfaruk on 6/30/2016.
 * B-17210_S2: As a domestic customer, I select RUSH as my shipping method
 */
public class Scen01_S2 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBagPage.isRushShippingDisplayedOnBag("11435", dataObject.getSkuListInfo().get(0));
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();

    }
}
