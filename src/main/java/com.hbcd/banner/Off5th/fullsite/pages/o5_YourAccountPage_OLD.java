package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.overlays.o5_AddressOverlay_OLD;
import com.hbcd.banner.commomplatform.fullsite.pages.YourAccountPage_OLD;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.pages.YourAccountPage;

/**
 * Created by 461967 on 6/1/2016.
 */
public class o5_YourAccountPage_OLD extends YourAccountPage_OLD {
    @Override
    public AddressOverlay ClickAddBilling() throws Exception {
        super.ClickAddBilling();
        return new o5_AddressOverlay_OLD();
    }

    @Override
    public AddressOverlay ClickAddShipping() throws Exception {
        super.ClickAddShipping();
        return new o5_AddressOverlay_OLD();
    }

    public YourAccountPage GoToMyAcccount() throws Exception {
        super.GoToMyAcccount();
        return new o5_YourAccountPage_OLD();
    }
}
