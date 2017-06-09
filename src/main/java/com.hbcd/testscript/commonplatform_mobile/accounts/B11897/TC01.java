package com.hbcd.testscript.commonplatform_mobile.accounts.B11897;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/3/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.ClickCreateAccountBtn();
        cap.IsCreateAccountPage();
        cap.IsMoreNumMsgPresent("Already a More! member?");
        cap.IsFirstNamePresent();
        cap.IsLastNamePresent();
        cap.IsEmailPresent();
        cap.IsPasswordPresent();
        cap.IsConfPasswordPresent();
        cap.IsPhonePresent();
        cap.IsZipPresent();
    }
}
