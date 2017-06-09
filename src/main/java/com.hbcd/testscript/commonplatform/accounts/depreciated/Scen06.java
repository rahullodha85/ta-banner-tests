package com.hbcd.testscript.commonplatform.accounts.depreciated;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 2/15/2016.
 */
public class Scen06 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(),dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsYourRewardsPresent();
        accSum.IsMoreNumberPresent(dataObject.getSkuListInfo().get(0));
    }
}
