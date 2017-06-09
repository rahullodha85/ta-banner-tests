package com.hbcd.banner.validations.Paypal;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;

public class ValidatePaypalReview {

    public static void ShippingAddressContains(String address) throws Exception {

        Switch.toFrame("envoyId");

        if (Find.Object("pReviewShipTo").getText().value().contains(address)) {
            System.out.println("Shipping Address validation Pass");
        } else {
            System.out.println("Shipping Address validation Fail");
        }
        Switch.toDefaultContent();
    }

    public static void BillingAddressContains(String address) throws Exception {

        Switch.toFrame("envoyId");
        if (Find.Object("pReviewBillTo").getText().value().contains(address))
            System.out.println("Billing Address validation Pass");
        else
            System.out.println("Billing Address validation Fail");
        Switch.toDefaultContent();
    }
}
