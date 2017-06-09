package com.hbcd.testscript.commonplatform_mobile.accounts.B11898;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/7/2016.
 */
public class TC04 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.ClickCreateAccountBtn();
        cap.IsCreateAccountPage();
        cap.ClickCreateAccount();
        cap.IsFirstNameErrorTextPresent("This field is required");
        cap.IsLastNameErrorTextPresent("This field is required");
        cap.IsEmailErrorTextPresent("This field is required");
        cap.IsPwdErrorTextPresent("This field is required");
        cap.IsConfPwdErrorTextPresent("This field is required");
    }
}
