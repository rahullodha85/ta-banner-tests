package com.hbcd.testscript.commonplatform_mobile.accounts.B11752;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 4/11/2016.
 */
public class TC04 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Payment");
        accPay.IsAccountsPaymentPage();
        accPay.ClickEdit(1);
        editPay.IsEditPaymentOverlay();
        editPay.ClickCancel();
        accPay.IsAccountsPaymentPage();
        accPay.ClickEdit(1);
        editPay.IsEditPaymentOverlay();
        editPay.ClickX();
        accPay.IsAccountsPaymentPage();
    }
}
