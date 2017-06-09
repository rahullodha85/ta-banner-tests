package com.hbcd.banner.validations.s5a;


import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateLearnMoreShopRunner {

    public static void validateMembershipPromo(){

        StepLogger.validate(Check.ObjectPresent,"membershipPromoShoprunner_AAF");
    }
}
