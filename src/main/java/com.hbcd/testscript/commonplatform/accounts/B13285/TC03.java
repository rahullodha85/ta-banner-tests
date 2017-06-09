package com.hbcd.testscript.commonplatform.accounts.B13285;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 4/6/2016.
 */
public class TC03 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.CheckOrderStatus("", "");
        sip.IsOrderNumErrorTextPresent("This field is required.");
        sip.IsBillingZipErrorTextPresent("This field is required.");
    }
}
