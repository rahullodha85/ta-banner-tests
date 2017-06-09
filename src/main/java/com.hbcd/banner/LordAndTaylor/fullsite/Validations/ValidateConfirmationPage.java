package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 6/30/2016.
 * validateConfirmation Page class has been created to store all the validations related to the "THANK YOU" Page
 *
 */
public class ValidateConfirmationPage {

    public static void isStandardShippingDisplayedONConfPage() throws Exception{

        if (Find.Object("ltStdShiipingConfPage_AAF").isPresent()){
            Report.pass("Shipping and Handling with Standard Shipping is displayed on Thank You Page");
        }else{
            Report.fail("Shipping and Handling with Standard Shipping is NOT displayed on Thank You Page");
        }
    }

    public static void isCancelButtonRemoved() throws Exception {
        if(Find.Object("ltConfPageCancelOrd_AAF").getText().value().contains("Cancel Order Placed in the Past 20 Minutes")){
            Report.pass("Cancel Order is Removed from Thank You Page");
        }else{
            Report.fail("Cancel Order is NOT Removed");
        }
    }
}
