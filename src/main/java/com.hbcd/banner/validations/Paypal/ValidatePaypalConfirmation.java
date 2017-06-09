package com.hbcd.banner.validations.Paypal;

import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Switch;
import com.hbcd.utility.common.Type.PropertyType;

public class ValidatePaypalConfirmation {

    public static void Confirmation() throws Exception {
        Switch.toFrame("envoyId");
        if (New.Object("").setProperty(PropertyType.ID, "envoyApp").getText()
                .value().contains("OrderPage Submitted")) {
            System.out.println("Validate Confirmation Pass");
        } else {
            System.out.println("Validate Confirmation Fail");
        }
        Switch.toDefaultContent();
    }
}
