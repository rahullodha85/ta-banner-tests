package com.hbcd.testscript.s5a.accountSection;

import com.hbcd.banner.validations.s5a.ValidateMyAccountPage;
import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 461967 on 12/11/2015.
 */
public class Scen05 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(" ");
        nav.HoverOverSignIn().ClickLinkFromDrawer("Your Account");
        ValidateSignInPage.IsSignInPage();
        yap.CreateRandomAccount("test@test.com");
        ValidateMyAccountPage.checkIfUserSignedIn("Hello");
        yap.ClickBillingAddressBook();
        yap.AddNewAddress("Automation","Testing","250 vesey st","","New York",
                "United States","New York","10018","201","111","111","");
        ValidateMyAccountPage.ValidateMessage("billing address changes saved");
    }
}
