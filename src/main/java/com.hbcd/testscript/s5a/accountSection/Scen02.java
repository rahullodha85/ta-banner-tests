package com.hbcd.testscript.s5a.accountSection;

import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.banner.validations.s5a.ValidateMyAccountPage;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 461967 on 12/10/2015.
 */
public class Scen02 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(" ");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Your Account");
        ValidateSignInPage.IsSignInPage();
        yap.CreateRandomAccount("test@test.com");
        ValidateMyAccountPage.checkIfUserSignedIn("Hello");
    }

}
