package com.hbcd.testscript.s5a.accountSection;

import com.hbcd.banner.validations.s5a.ValidateMyAccountPage;
import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 461967 on 12/11/2015.
 */
public class Scen03 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(" ");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Your Account");
        ValidateSignInPage.IsSignInPage();
        yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
        ValidateMyAccountPage.checkIfUserSignedIn("Automation");
        nav.HoverOverSignIn().ClickLinkFromDrawer("SignOut");
        ValidateSignInPage.IsSignInPage();
    }
}