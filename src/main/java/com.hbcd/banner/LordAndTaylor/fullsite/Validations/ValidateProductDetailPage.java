package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 10/31/2016.
 * All the validations related to PDP will be accomodiated in this class
 */
public class ValidateProductDetailPage{

    public static void isUserOnProductDetailPage() throws Exception{

        if (Find.Object("ltPdpPage_AAF").isPresent() || Find.Object("ltPdpSoldOut_AAF").isPresent()){
            Report.pass("User is on PDP Page");
        }else{
            Report.dataFail("Item is SOLD OUT");
        }
    }

    public static void isItemShopRunnerEligible() throws Exception{
        if (Find.Object("ltPdpShoprunner_AAF").isPresent()){
            Report.pass("The Selected Item is ShopRunner Eligible");
        }else{
            Report.fail("Item is NOT ShopRunner Eligible");
        }
    }


}
