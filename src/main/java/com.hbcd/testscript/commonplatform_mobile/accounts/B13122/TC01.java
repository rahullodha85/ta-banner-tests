package com.hbcd.testscript.commonplatform_mobile.accounts.B13122;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by 461967 on 4/5/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        accSum.IsSummaryPage();
        accSum.ClickAccountNav("Order History");
        ordHis.IsOrderHistoryPage();
        accSum.ClickAccountNav("Shipping Address Book");
        accShp.IsShippingAddrPage();
        accSum.ClickAccountNav("Billing Address Book");
        accBill.IsBillingAddrPage();
        accSum.ClickAccountNav("Payment");
        accPay.IsAccountsPaymentPage();
        accSum.ClickAccountNav("Account Settings");
        accSet.IsAccountSettingsPage("Password Settings");
        accSum.ClickAccountNav("Account Summary");
        accSum.IsSummaryPage();
    }
}
