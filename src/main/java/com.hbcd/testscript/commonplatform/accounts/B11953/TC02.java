package com.hbcd.testscript.commonplatform.accounts.B11953;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/7/2016.
 */
public class TC02 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.ClickCreateAccountBtn();
        cap.IsCreateAccountPage();
        cap.IsCheckBoxPresent("Saks Off Fifth");
        cap.IsCheckBoxPresent("Saks Fifth Avenue");
    }
}
