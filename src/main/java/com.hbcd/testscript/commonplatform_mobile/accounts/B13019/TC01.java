package com.hbcd.testscript.commonplatform_mobile.accounts.B13019;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 3/28/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Payment");
        accPay.IsAccountsPaymentPage();
        accPay.PaymentNamePresent(1);
        accPay.IsDefaultPayment(1);
    }
}
