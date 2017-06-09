package com.hbcd.banner.validations.s5a;


import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateShoprunnerExpresscheckoutBag {

    public static void hasIteminShoprunnerExpressCheckoutBag() throws Exception {

        StepLogger.validate(Check.ObjectPresent,"hasIteminExpresscheckoutBag_AAF");

    }

    public static void hasTwodayFreeShippingPresentforExpressCheckout() throws Exception{

        StepLogger.validate(Check.ObjectPresent, "hasTwodayFreeShipping_AAF");

    }

    public static void estimatedSalesTaxCalculated() throws Exception{

        StepLogger.validate(Check.ObjectPresent, "estimatedSalesTaxExpresscheckout_AAF");
    }

    public static void shiptoExpressCheckout() throws Exception{

        StepLogger.validate(Check.ObjectPresent, "shiptoExpressCheckout_AAF");
    }

    public static void payWithExpressCheckout() throws Exception{
        StepLogger.validate(Check.ObjectPresent, "payWithExpressCheckout_AAF");
        Thread.sleep(3000);
        if (Find.Object("shoprunnerExpresscheckoutComplete_AAF").isDisplayed());
        {
            Find.Object("shoprunnerExpresscheckoutComplete_AAF").click();
        }
    }

    public static void thankyouConfirmationPage() throws Exception{
        if (Find.Object("expressCheckoutConfirmation_AAF").isDisplayed()){
        System.out.println("Confirmation Massage is Present");
    }else{
        System.out.println("Confirmation page is not Present");
        }


    }

    public static void returnToBagExpressCheckout()throws Exception{
        if(Find.Object("returnToBagExpressCheckoutButton_AAF").isDisplayed()){
        System.out.println("Return to Bag is Present");
        }else{
            System.out.println("Return to Bag is Not Present");
        }
    }


}