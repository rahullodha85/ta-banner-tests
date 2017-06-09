package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateYap {
    public static void hasShipping(String address) {
        StepLogger.validate(Check.TextPresent, "yapMiniAddressV", address);

    }

    public static void isDisplayed() {
        StepLogger.validate(Check.TextPresent, "yapBody", "CONTACT");

    }

    public static void hasInvalidCredentialsError() {
        StepLogger.validate(Check.TextPresent, "yapErrorMessageLogin", "do not match a registered saks.com");

    }

    public static void hasPaypalPayment() throws Exception {

        if (Find.Object("yapOrderDetailsForm").getText().value().contains("PayPal")) {

            System.out.println("Pass");
        }
        StepLogger.validate(Check.TextPresent, "yapOrderDetailsForm", "PayPal");

    }

}
