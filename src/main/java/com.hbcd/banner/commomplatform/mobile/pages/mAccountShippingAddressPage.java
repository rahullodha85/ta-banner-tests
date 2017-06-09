package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.commonbanner.base.pages.AccountShippingAddressPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;

/**
 * Created by 461967 on 4/5/2016.
 */
public class mAccountShippingAddressPage extends AccountShippingAddressPageBase {
    @Override
    public void IsShippingAddrPage() throws Exception {
        if (Find.Object("shpAddr_Title").isPresent()) {
            Report.pass("User is on Account Shipping Address Page");
        } else {
            Report.fail("User is not on Account Shipping Address Page");
        }
    }

    @Override
    public void ClickEdit(int index) throws Exception {
        if (Find.MultipleObjects("shpAddr_AddrCard").size() >= index) {
            Find.MultipleObjects("shpAddr_AddrCard").select(index).storeAs("temp");
            if (Use.CapturedObject("temp").FindObject("shpAddr_EditBtn").isPresent()) {
                Report.pass("Shipping address edit button found and clicked");
                Use.CapturedObject("temp").FindObject("shpAddr_EditBtn").click();
            } else {
                Report.fail("Shipping address " + (index-1) + " does not have edit button");
            }
        } else {
            Report.dataFail("This user does not have shipping address " + (index-1));
        }
    }

    @Override
    public void IsDefaultAddr(int index) throws Exception {
        if (Find.MultipleObjects("shpAddr_AddrCard").size() >= index) {
            Find.MultipleObjects("shpAddr_AddrCard").select(index).storeAs("temp");
            if (Use.CapturedObject("temp").FindObject("shpAddr_isDefault").isPresent()) {
                Report.pass("Shipping address edit button found and clicked");
            } else {
                Report.fail("Shipping address " + (index-1) + " does not have edit button");
            }
        } else {
            Report.dataFail("This user does not have shipping address " + (index-1));
        }
    }
}
