package com.hbcd.testscript.lt.ltm_checkout_userstories.B18002;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidatePaymentPage;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/1/2016.
 * Validate 11 Digits PLCC Card
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.EnterPaymentDetails("Lord & Taylor","41111111111","Christopher Jones");
        ValidatePaymentPage.isCCContainsValidNumbers("41111111111");
        pap.ClickCheckout();
    }
}
