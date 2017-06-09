package com.hbcd.testscript.commonplatform.accounts.B12861;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/23/2016.
 */
public class TC03 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountSettings();
        accSet.IsAccountSettingsPage("Password Settings");
        accSet.ClickEditProfile();
        editPro.IsEditProfile("Edit Profile");
        editPro.ClickX();
        accSet.IsAccountSettingsPage("Password Settings");
    }
}
