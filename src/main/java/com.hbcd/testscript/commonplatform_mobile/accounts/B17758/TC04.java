package com.hbcd.testscript.commonplatform_mobile.accounts.B17758;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by 461967 on 11/2/2016.
 */
public class TC04 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsSaksFirstSectionPresent("SaksFirst Benefits");
        accSum.ClickLinkYourSaksFirst();
        saksFirst.IsLinkYourSaksFirstOverlay();
        saksFirst.ClickCancel();
        accSum.IsSummaryPage();
        accSum.ClickLinkYourSaksFirst();
        saksFirst.IsLinkYourSaksFirstOverlay();
        saksFirst.ClickX();
        accSum.IsSummaryPage();
    }
}
