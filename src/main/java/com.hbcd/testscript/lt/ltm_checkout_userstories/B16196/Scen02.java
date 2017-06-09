package com.hbcd.testscript.lt.ltm_checkout_userstories.B16196;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/23/2016.
 *L&TM: Remove Multi Address Shipping
 * S3: Ship separately ( Bag ) Click here
 GIVEN I am a Lord & Taylor customer
 AND I have 2 or more items in my bag
 WHEN I open my bag
 THEN I don't see any option to ship items separately
 */
public class Scen02 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBagPage.isMultiAddressShippingRemovedFromBag();


    }
}
