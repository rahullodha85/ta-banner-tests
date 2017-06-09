package com.hbcd.testscript.commonplatform_mobile.accounts.B12894;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/24/2016.
 */
public class TC04 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Order History");
        ordHis.IsOrderHistoryPage();
        ordHis.ClickExpandCollapse(1);
        ordHis.IsOrderExpanded(1);
        ordHis.ClickExpandCollapse(1);
        ordHis.IsOrderCollapsed(1);
    }
}