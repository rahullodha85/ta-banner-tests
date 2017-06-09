package com.hbcd.testscript.lt.ltm_checkout_userstories.B17210;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateConfirmationPage;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 6/30/2016.
 * B-17210
 * L&TM: Shipping Tiers (No AMS Integration)
 * S1: As a domestic customer, My order is shipped via STANDARD
 */
public class Scen01_S1 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBagPage.isDefaultStandardShippingApplied(dataObject.getSkuListInfo().get(0));
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
        ValidateConfirmationPage.isStandardShippingDisplayedONConfPage();

    }
}
