package com.hbcd.testscript.lt.ltm_checkout_userstories.B17570;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidatePaymentPage;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 8/24/2016.
 * L&TM: PLCC field validation
 * S1: Validate Non-Numeric Characters
 GIVEN I have selected "Lord & Taylor" from the Payment Type pulldown menu
 WHEN I type in non-numeric characters into the credit card field
 AND I click 'continue checkout'
 THEN I will see the error message "Card number should be digit".
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
        pap.EnterPaymentDetails("MasterCard", "5100000010001004", "Christopher Reynolds" );
        ValidatePaymentPage.containsOnlyNumbers("5100000010001004");
        ValidatePaymentPage.isCreditcardNumberValid("5100000010001004");

    }
}
