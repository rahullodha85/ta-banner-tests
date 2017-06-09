package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 12/10/2015.
 */
public class ValidateMyAccountPage {
    public static void checkIfUserSignedIn(String name) throws Exception{
        Thread.sleep(1000);
        if(Find.Object("conMyAccountBtn").getText().value().contains(name))
            Report.pass("New User is created and signed in");
        else Report.fail("New User is not signed in after Account Creation");

        if (Find.Object("navYourAccount_wk").getText().value().contains("Welcome, "+name))
            Report.pass("Welcome is on the page");
        else Report.fail("Welcome is NOT on the page");
    }

    public static void ValidateMessage(String msg) throws Exception {
        if(Find.Object("accountMsg_RL").getText().value().toLowerCase().contains(msg)){
            Report.pass("Address change msg verified",
                        BrowserAction.screenshot());
        }else{
            Report.fail("Address change msg not displayed as expected",
                    BrowserAction.screenshot());
        }
    }
    public static void ValidateShippingAddress(String msg) throws Exception {
        if(Find.Object("htmlPage").getText().value().toLowerCase().contains(msg)){
            Report.pass("New Address verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("Address not displayed as expected",
                    BrowserAction.screenshot());
        }
    }
}
