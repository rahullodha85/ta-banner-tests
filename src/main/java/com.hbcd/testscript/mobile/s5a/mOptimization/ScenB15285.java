package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidatePasswordResetEmail;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Mobile Web - Check Out - Forgot Password and Password Confirmation
 * B15285
 */
public class ScenB15285 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        bag.ClickForgetPasswordBagMobile();
        ValidateBag.hasForgetYourPasswordDisplayed();
        sip.EnterEmailAddressMobile("testc2@test.com");
        //ValidatePasswordResetEmail.hasPasswordResetEmailSent(); This Function is not working, Yulia
    }


}
