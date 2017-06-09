package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.OrderDetailsPage;
import com.hbcd.commonbanner.base.pages.OrderDetailsPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 4/7/2016.
 */
public class mOrderDetailsPage extends OrderDetailsPageBase {
    @Override
    public void IsOrderDetailsPage() throws Exception {
        if(Find.Object("ordSts_Title").isPresent()) {
            Report.pass("User is on Order Details Page");
        } else if (Find.Object("sip_Error").isPresent()) {
            Report.dataFail("Entered Order Number/Zip Code combination does not match any order");
        } else {
            Report.fail("User is not on Order Details Page");
        }
    }
}
