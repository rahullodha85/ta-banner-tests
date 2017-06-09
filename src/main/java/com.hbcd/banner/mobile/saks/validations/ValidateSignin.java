package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 4/4/2016.
 */
public class ValidateSignin {

    public static void hasCheckHighlightedError() throws Exception{
        if (Find.Object("checkHighlightedErrorLogin_AAF").isPresent()){
            Report.pass("Error was Highlighted", BrowserAction.screenshot());
        }else{
            Report.fail("Error was NOT Highlighted",BrowserAction.screenshot());
        }
    }


    public static void hasErrorMessage(String errorMessage) throws Exception{

        if (Find.Object("errorMessageLogin_AAF").isPresent()){
            Find.Object("errorMessageLogin_AAF").getText().value().contains(errorMessage);
            Report.pass("Error Message Appeared"+errorMessage,BrowserAction.screenshot());
        }else{
            Report.fail("Error Message is NOT appeared",BrowserAction.screenshot());
        }
    }
}
