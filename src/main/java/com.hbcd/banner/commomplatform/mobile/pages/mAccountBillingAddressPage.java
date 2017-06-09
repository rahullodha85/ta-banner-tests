package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.commonbanner.base.pages.AccountBillingAddressPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 4/5/2016.
 */
public class mAccountBillingAddressPage extends AccountBillingAddressPageBase {
    @Override
    public void IsBillingAddrPage() throws Exception {
        if (Find.Object("billAddr_Title").isPresent()) {
            Report.pass("User is on Account Billing Address Page");
        } else {
            Report.fail("User is not on Account Billing Address Page");
        }
    }
}
