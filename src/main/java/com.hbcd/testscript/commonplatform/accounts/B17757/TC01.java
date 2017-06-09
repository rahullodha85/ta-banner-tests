package com.hbcd.testscript.commonplatform.accounts.B17757;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by 461967 on 11/1/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsSaksFirstSectionPresent("SaksFirst Benefits");
        accSum.IsLinkYourSaksFirstPresent("LINK SAKSFIRST");
    }
}
