package com.hbcd.testscript.commonplatform.accounts.B17760;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by 461967 on 11/2/2016.
 */
public class TC03 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsSaksFirstSectionPresent("SaksFirst Benefits");
        accSum.ClickLinkYourSaksFirst();
        saksFirst.IsLinkYourSaksFirstOverlay();
        saksFirst.ClickSubmit("", "", "", "");
        saksFirst.IsFirstNameErrorPresent();
        saksFirst.IsLastNameErrorPresent();
        saksFirst.IsZipCodeErrorPresent();
        saksFirst.IsAccNumErrorPresent();
    }
}
