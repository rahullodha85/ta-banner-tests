package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.ContactCenterPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class ContactCenterPage extends ContactCenterPageBase {
    @Override
    public void LoginWith(String username, String password) throws Exception {

        Find.Object("ccUserNameTxt").input(username);
        Find.Object("ccPasswordTxt").input(password);
        StepLogger.validate(Check.ObjectPresent, "ccLoginBtn");
        Find.Object("ccLoginBtn").click();

    }
    @Override
    public void SearchOrder(String orderNumber) throws Exception {
        Switch.toFrame("cc_frame_content");
        Find.Object("ccOrderSearchTxt").input(orderNumber);
        StepLogger.validate(Check.ObjectPresent, "ccSubmitSearchBtn");
        Find.Object("ccSubmitSearchBtn").click();
    }
}
