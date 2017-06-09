package com.hbcd.testscript.commonplatform.accounts.B12392;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/21/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.OrderHasOrderDate(2);
        accSum.OrderHasOrderItemCount(2);
        accSum.OrderHasOrderNumber(2);
        accSum.OrderHasOrderStatus(2);
        accSum.OrderHasOrderTotal(2);
    }
}
