package com.hbcd.testscript.commonplatform.accounts.depreciated;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/2/2016.
 */
public class Scen08 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(),dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.IsFirstOrderPresent();
        accSum.OrderDetailHasPaymentMethod(1);
        accSum.OrderDetailHasBillingAddress(1);
        accSum.OrderDetailHasSummary(1);
        accSum.OrderDetailHasShippingSection(1);
        accSum.OrderDetailHasShippingAddress(1);
        accSum.OrderDetailHasShippingMethod(1);
    }
}
