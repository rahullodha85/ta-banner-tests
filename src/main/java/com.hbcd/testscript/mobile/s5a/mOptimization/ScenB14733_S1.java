package com.hbcd.testscript.mobile.s5a.mOptimization;


import com.hbcd.banner.mobile.saks.validations.ValidateLogin;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by 901124 on 3/18/2016.
 */
public class ScenB14733_S1 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        ValidateLogin.hasEmailTextBox();
        ValidateLogin.hasPasswordTextBox();
        ValidateLogin.hasGuestCheckOutButton();
        ValidateLogin.hasForgotPasswordLink();

    }
}