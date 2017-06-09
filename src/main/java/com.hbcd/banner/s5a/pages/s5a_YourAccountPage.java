package com.hbcd.banner.s5a.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.YourAccountPage_OLD;
import com.hbcd.banner.s5a.overlays.s5a_AddressOverlay;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.pages.YourAccountPage;
import com.hbcd.scripting.core.Find;

public class s5a_YourAccountPage extends YourAccountPage_OLD {

    @Override
    public void Login(String email, String pwd) throws Exception {
        Find.Object("o5m_yapUsername_wk").input(email);
        Find.Object("o5m_yapPwd_WS").input(pwd);
        Find.Object("o5m_yapSignInBtn_WS").click();
    }

    @Override
    public AddressOverlay ClickAddBilling() throws Exception {
        super.ClickAddBilling();
        return new s5a_AddressOverlay();
    }

    @Override
    public AddressOverlay ClickAddShipping() throws Exception {
        super.ClickAddShipping();
        return new s5a_AddressOverlay();
    }

    public YourAccountPage GoToMyAcccount() throws Exception {
        super.GoToMyAcccount();
        return new s5a_YourAccountPage();
    }
}
