package com.hbcd.testscript.commonplatform_mobile.accounts.B13285;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 4/6/2016.
 */
public class TC02 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.CheckOrderStatus("abcdef", "!@#$%");
        sip.IsOrderNumErrorTextPresent("Please enter a valid order number.");
        sip.IsBillingZipErrorTextPresent("Invalid format.");
    }
}
