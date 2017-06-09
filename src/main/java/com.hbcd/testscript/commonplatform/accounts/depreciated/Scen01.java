package com.hbcd.testscript.commonplatform.accounts.depreciated;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 1/20/2016.
 */
public class Scen01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
 sip.IsSignInPage();
        sip.IsSignInPage();
        sip.IsSignInSectionPresent();
        sip.IsCreateAccountSectionPresent();
        //still need to implement Order status section validation
    }
}
