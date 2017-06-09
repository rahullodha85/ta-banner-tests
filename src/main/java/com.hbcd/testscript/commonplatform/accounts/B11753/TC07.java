package com.hbcd.testscript.commonplatform.accounts.B11753;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 5/2/2016.
 */
public class TC07 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Shipping Address Book");
        accShp.IsShippingAddrPage();
        accShp.ClickEdit(2);
        editShp.IsShippingAddrOverlay();
        editShp.EditAddr("United States", "testfName", "testlName",
                        "testComp", "250 vesey st", "",
                        "New York", "New York", "10080", "1111111111", true);
        accShp.IsShippingAddrPage();
    }
}