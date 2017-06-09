package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidatePap;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.mobile.saks.validations.ValidateSignin;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

/**
 * [SPIKE] Mobile Web - CheckOut - Sign in
 */
public class ScenB14714 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        lgn.EnterCredentials(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateSignin.hasCheckHighlightedError();
        ValidateSignin.hasErrorMessage("The email address or password you have entered is not valid. Please check both trying again or click on Forget Password.");

    }
}
