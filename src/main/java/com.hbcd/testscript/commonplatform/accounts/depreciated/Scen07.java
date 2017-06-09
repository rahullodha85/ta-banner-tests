package com.hbcd.testscript.commonplatform.accounts.depreciated;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/1/2016.
 */
public class Scen07 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(),dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsFirstOrderPresent();
        accSum.OrderRowPresent(2);
        accSum.OrderHasOrderDate(2);
        accSum.OrderHasOrderNumber(2);
        accSum.OrderHasOrderItemCount(2);
        accSum.OrderHasOrderTotal(2);
        accSum.OrderHasOrderStatus(2);
    }
}
