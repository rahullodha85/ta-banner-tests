package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by zakirkhan on 12/2/2015.
 */
public class ValidateThankYou {

    public static void ShippingMethod(String shipMethod, String upc)
            throws Exception {

       if (Find.Object("confShippingMethod_WS").changeChildAttributeContainsValue("data-cartproductcode", upc).getText().value().contains(shipMethod)) {

            Report.pass("Shipping Method validation Pass", BrowserAction.screenshot());
        } else {
            Report.fail("Shipping Method validation Fail", BrowserAction.screenshot());
        }

    }
    public static void hasShopRunnerEligibleSign(String upc) throws Exception {

        if(Find.Object("shiandBillShopRunnerEligible_zk").changeContainsText(upc).getText().value().contains("Eligible"))
            Report.pass("Validation PASS");
        else
            Report.fail("Validation FAIL");
    }

    public static void hasNoShopRunnerEligibleSign() throws Exception{
        StepLogger.validate(Check.TextNotPresent, "rspSRShippingMethod_zk", "Eligible");
    }

}
