package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.PdpPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LT_PdpPage extends PdpPage {

    @Override
    public void ClickShoprunnerLearnMore() throws Exception {

        if (Find.Object("ltshprLearnMore_AAF").getText().value().equalsIgnoreCase("learn more")){
            Report.pass("User Clicks on the Learn More from ShopRunner Icon");
            Find.Object("ltshprLearnMore_AAF").click();
        }else{
            Report.fail("Learn More Shoprunner Icon is NOT available");
        }

    }
}
