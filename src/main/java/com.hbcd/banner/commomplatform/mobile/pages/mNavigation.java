package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.commonbanner.base.pages.NavigationPageBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 1/19/2017.
 */
public class mNavigation extends NavigationPageBase {
    @Override
    public void closeMiniBag() throws Exception {
        Find.Object("pageTop").mouseClick();
    }

    @Override
    public void ClickSignInLink() throws Exception {
        clickNavMenu();
        if(Find.Object("nav_SignInLink_RL").isPresent()) {
            Report.pass("Sign-In Link is present on Navigation Menu");
            Find.Object("nav_SignInLink_RL").click();
        } else {
            Report.systemFail("Sign-In Link is not present on Navigation Menu", BrowserAction.screenshot());
        }
    }

    @Override
    public void clickNavMenu() throws Exception {
        if(Find.Object("nav_NavigationMenuButton_RL").isPresent()) {
            Report.pass("Navigation menu button is present");
            Find.Object("nav_NavigationMenuButton_RL").click();
        } else {
            Report.fail("Navigation menu button is not present");
        }
    }
}
