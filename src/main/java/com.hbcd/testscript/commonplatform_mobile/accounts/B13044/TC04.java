package com.hbcd.testscript.commonplatform_mobile.accounts.B13044;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/29/2016.
 */
public class TC04 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Account Settings");
        accSet.IsAccountSettingsPage("Password Settings");
        accSet.ClickChangePwd();
        chngPwd.IsChangePwdOverlay("Change Password");
        chngPwd.ClickSubmit();
        chngPwd.VerifyOldPasswordError("This field is required.");
        chngPwd.VerifyNewPasswordError("This field is required.");
        chngPwd.VerifyConfPasswordError("This field is required.");
    }
}
