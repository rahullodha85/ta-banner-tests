package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 3/28/2016.
 */
public class ValidatePayment {

    public static void hasUserLandedOnPaymentPage(String payment) throws Exception{

        if(Find.Object("paymentPage_AAF").isPresent()){
            Report.pass("User Landed on " + payment, BrowserAction.screenshot());
        }else{
            Report.fail("User is NOT landed on Payment Page");
        }
    }
}
