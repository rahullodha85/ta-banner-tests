package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 12/10/2015.
 */
public class ValidateSignInPage {

    public static void IsSignInPage() throws Exception {

        if(Find.Object("yapLoginEmail").isPresent()){
            Find.Object("yapLoginEmail").hover();
            Report.pass("User on signIn page and signIn email text box is displayed and verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("User not on signIn page and email text box is not displayed",
                        BrowserAction.screenshot());
        }
    }
}
