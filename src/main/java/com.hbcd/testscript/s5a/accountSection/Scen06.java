package com.hbcd.testscript.s5a.accountSection;

import com.hbcd.banner.validations.s5a.ValidateMyAccountPage;
import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 461967 on 1/4/2016.
 */
public class Scen06 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(" ");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Your Account");
        ValidateSignInPage.IsSignInPage();
        yap.CreateRandomAccount("test@test.com");
        ValidateMyAccountPage.checkIfUserSignedIn("Hello");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Payment Method");
        yap.AddCreditCard(dataObject.getCCType(),dataObject.getCCNumber(),
                "test",dataObject.getExpMonth(),dataObject.getExpYear());
    }
}
//