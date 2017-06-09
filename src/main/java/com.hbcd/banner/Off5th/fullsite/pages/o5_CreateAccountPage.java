package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.CreateAccountPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/14/2016.
 */
public class o5_CreateAccountPage extends CreateAccountPage {
    @Override
    public void IsMoreNumMsgPresent(String text) throws Exception {
        if(Find.Object("cap_MoreNumMsg").isPresent()){
            if(Find.Object("cap_MoreNumMsg").getText().value().contains(text)){
                Report.pass("\"Already a More Member?\" message present " +
                        "and verified on Create Account Page");
            }else {
                Report.fail("Create Account Page More Member message text: " +
                        Find.Object("cap_MoreNumMsg").getText().value() +
                        "does not match expected value: " + text);
            }
        }else {
            Report.fail("\"Already a More Member?\" message not present " +
                    "on Create Account Page");
        }
    }
}
