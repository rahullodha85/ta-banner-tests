package com.hbcd.testscript.commonplatform_mobile.accounts.B11897;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/3/2016.
 */
public class TC05 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.ClickCreateAccountBtn();
        cap.AreYouCanadianSelection("Yes");
        cap.IsCanadianCustomerAgreementPresent();
        cap.IsPrivacyPolicyPresent();
    }
}
