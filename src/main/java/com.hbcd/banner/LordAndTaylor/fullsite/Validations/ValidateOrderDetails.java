package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.banner.saks.alfresco.Utility;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.helper.Common;
import org.apache.commons.collections.functors.ChainedClosure;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aalfaruk on 8/30/2016.
 * Validate CC with hasCreditCardWithNumber() method used Regex to find the last four and validate the last four digits of CC
 */
public class ValidateOrderDetails{
    public static void isOrderDetailAvailable(String orderNumber, String zipCode) throws Exception{
        if (Find.Object("ltBillingInfo_AAF").isPresent()){
            Report.pass("User can able to see the OrderNumber " + orderNumber + " And Zipcode: " + zipCode);
        }else{
            Report.fail("OrderNumber is NOT valid");
        }
    }

    public static void hasCreditCardWithNumber() throws Exception{
        String ccDetails=Find.MultipleObjects("ltOrdHosCcNumber_AAF").getText().get(1);
        String pattern = "(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(ccDetails);
        if (m.find()){
            Report.pass(m.group(0) + " is valid Last Four Digits of a CC");
        }else {
            Report.fail(m.group(0) + " is NOT the valid Last Four Digits of a CC");
        }
    }
}
