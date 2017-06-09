package com.hbcd.testscript.commonplatform.accounts.B11758;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 5/2/2016.
 */
public class TC03 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Account Settings");
        accSet.IsAccountSettingsPage("Password Settings");
        accSet.ClickEditEmailPref();
        emailPref.IsEmailPrefOverlay();
        emailPref.ClickCancel();
        accSet.IsAccountSettingsPage("Password Settings");
        accSet.ClickEditEmailPref();
        emailPref.IsEmailPrefOverlay();
        emailPref.ClickX();
        accSet.IsAccountSettingsPage("Password Settings");
    }
}
