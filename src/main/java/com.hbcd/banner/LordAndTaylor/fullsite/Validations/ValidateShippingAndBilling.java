package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

import java.lang.reflect.Field;

/**
 * Created by aalfaruk on 8/23/2016.
 * Created for all the validations related to Shipping and Billing Address for LT
 */
public class ValidateShippingAndBilling {

    public static void isMultiAddressShippingRemoved() throws Exception{

        if(!Find.Object("ltShpBilling_AAF").getText().value().contains("Multiple Shipping Address")){
            Report.pass("MultiAddress Shipping is NOT Displayed in the Shipping and Billing Page");
        }else{
            Report.fail("MultiAddress Shipping is Displayed in the Shipping and Billing Page");
        }
    }

    public static void isShopRunnerTopBannerRemovedShippingAndBilling() throws Exception{

        if (!Find.Object("ltShpBilSrTopbanner_AAF").getText().value().contains("ShopRunner 2 Day FREE Shipping")){
            Report.pass("ShopRunner Top Banner has been Removed from Shipping and Billing Page");
        }else{
            Report.fail("ShopRunner Top Banner is available on the Top Banner");
        }

    }

    public static void isQLDisabledOnShippingAndBilling() throws Exception{

        if (!Find.Object("ltShpQlDisabled_AAF").isPresent()){
            Report.pass("Quick Look is disabled in Shipping And Billing Page");
        }else{
            Report.fail("Quick Look is NOT disabled");
        }
    }


}
