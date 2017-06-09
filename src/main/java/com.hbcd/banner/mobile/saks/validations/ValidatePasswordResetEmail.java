package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 4/1/2016.
 */
public class ValidatePasswordResetEmail {

    public static void hasPasswordResetEmailSent() throws Exception{

        if (Find.Object("passwordResetEmail_AAF").isPresent()){
            Report.pass("User gets the Password Reset Email", BrowserAction.screenshot());
        }else{
            Report.fail("User does NOT get the Password Reset Email",BrowserAction.screenshot());
        }
    }
}
