package com.hbcd.testscript.lt.ltm_checkout_userstories.B16007;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateProductDetailPage;
import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateShippingAndBilling;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 10/31/2016.
 * Verify if QuickLook is disabled on BagPage, and Shipping and BillingPage
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidateProductDetailPage.isUserOnProductDetailPage();
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBagPage.isQuickLookDisabledOnBagPage();
        bag.ClickCheckout().ClickGuestCheckout();
        ValidateShippingAndBilling.isQLDisabledOnShippingAndBilling();
    }
}
