package com.hbcd.testscript.s5a.accountSection;

import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 461967 on 12/10/2015.
 */
public class Scen01 extends ScenarioSaks {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(" ");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Your Account");
        ValidateSignInPage.IsSignInPage();
        nav.HoverOverSignIn().ClickLinkFromDrawer("Order History");
        ValidateSignInPage.IsSignInPage();
        nav.HoverOverSignIn().ClickLinkFromDrawer("Account Settings");
        ValidateSignInPage.IsSignInPage();
        nav.HoverOverSignIn().ClickLinkFromDrawer("Shipping Address Book");
        ValidateSignInPage.IsSignInPage();
        nav.HoverOverSignIn().ClickLinkFromDrawer("Billing Address Book");
        ValidateSignInPage.IsSignInPage();
        nav.HoverOverSignIn().ClickLinkFromDrawer("Payment Method");
        ValidateSignInPage.IsSignInPage();
    }
}
