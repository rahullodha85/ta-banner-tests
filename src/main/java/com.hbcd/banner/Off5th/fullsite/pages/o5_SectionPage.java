package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.SectionPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/1/2016.
 */
public class o5_SectionPage extends SectionPage {

    @Override
    public void ClickShopAll() throws Exception {
        if (Find.Object("leftNavShpAll_AAF").isPresent()){
            Report.pass("User Clicks on ShopAll");
            Find.Object("leftNavShpAll_AAF").click();
        }else{
            Report.fail("Left Nav Lists are NOT avaialble");
        }
    }
}
