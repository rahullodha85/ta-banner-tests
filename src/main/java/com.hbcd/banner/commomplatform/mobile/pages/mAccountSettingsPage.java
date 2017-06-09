package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.AccountSettingsPage;
import com.hbcd.commonbanner.base.pages.AccountSettingsPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 3/22/2016.
 */
public class mAccountSettingsPage extends AccountSettingsPageBase {
    @Override
    public void ClickChangePwd() throws Exception {
        if(Find.Object("accSet_ChangePwd").isPresent()){
            Find.Object("accSet_ChangePwd").click();
            Report.pass("Change Password button found and clicked");
        }else {
            Report.fail("Change Password button is not present on Account Settings Page");
        }
    }

    @Override
    public void ClickEditProfile() throws Exception {
        if (Find.Object("accSet_EditPro").isPresent()) {
            Find.Object("accSet_EditPro").click();
            Report.pass("Edit profile button found and clicked");
        } else {
            Report.fail("Edit profile button is not present on Account Settings Page");
        }
    }

    @Override
    public void IsAccountSettingsPage(String text) throws Exception {
        if(Find.Object("accSet_PwdSet").getText().value().contains(text)){
            Report.pass("User is on Account Settings page");
        }else {
            Report.fail("User is not on Account Settings page");
        }
    }

    @Override
    public  void VerifEmail(String text) throws Exception {
        if(Find.Object("accSet_Email").isPresent()){
            if(Find.Object("accSet_Email").getText().value().contains(text)){
                Report.pass("User Email value is same as expected Email value: " + text);
            }else {
                Report.fail("User Email value: " + Find.Object("accSet_Email").getText().value() +
                        " does not match expected Email value: " + text);
            }
        }else {
            Report.fail("Email field is not present on Account Settings Page");
        }
    }

    @Override
    public void VerifyFullName(String text) throws Exception {
        if(Find.Object("accSet_FullName").isPresent()){
            if(Find.Object("accSet_FullName").getText().value().contains(text)){
                Report.pass("User Full Name value is same as expected Email value: " + text);
            }else {
                Report.fail("User Full Name value: " + Find.Object("accSet_Email").getText().value() +
                        " does not match expected Email value: " + text);
            }
        }else {
            Report.fail("Full Name field is not present on Account Settings Page");
        }
    }

    @Override
    public void ClickEditEmailPref() throws Exception {
        if(Find.Object("accSet_EditEmailPref").isPresent()){
            Report.pass("Email prefernce edit button found and clicked");
            Find.Object("accSet_EditEmailPref").click();
        }else {
            Report.fail("Email prefernce edit button is not present on Account Settings Page");
        }
    }
}
