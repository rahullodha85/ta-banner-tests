package com.hbcd.testscript.lt.ltm_checkout_userstories.B16196;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateReviewAndSubmitPage;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/23/2016.
 *L&TM: Remove Multi Address Shipping
 * GIVEN I am a Lord & Taylor customer
 AND I have 2 or more items in my bag
 WHEN  I reach Review & Submit page
 THEN I don't see an option to ship to multiple addresses or to ship separately
 */
public class Scen03 extends ScenarioCommonPlatform {

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
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        ValidateReviewAndSubmitPage.isMultiAddressRemovedRs();
    }
}
