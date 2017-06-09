package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

/**
 * Created by 901124 on 3/21/2016.
 */
public class ScenB14936_S3 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);

        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("claudiasosa" + Common.getUniqueNumber() + "@s5a.com");
        shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true, "", "");
        ValidateShipping.hasEmailAddressRequiredText();
        ValidateShipping.hasPhoneRequiredText();
        ValidateShipping.InvalidEmailAddressError();
        ValidateShipping.InvalidPhoneError();
    }
}