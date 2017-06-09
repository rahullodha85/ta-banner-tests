package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.PaymentPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LT_PaymentPage extends PaymentPage {

    @Override
    public void EnterPaymentDetails(String cardType, String cardNumber, String cardHolderName) throws Exception {

        switch (cardType){
            case "Lord & Taylor":{
                if(Find.Object("ltCardTypeLt_AAF").isPresent()) {
                    Report.pass("User Selects the Lord & taylor Card");
                    Find.Object("ltCardTypeLt_AAF").select(1);
                    Find.Object("ltCcNumber_AAF").input(cardNumber);
                    Find.Object("ltPapCardHolderName_AAF").input(cardHolderName);
                }
                else{
                    Report.fail("Loard and Tylor card is NOT available");
                }
                break;
            }
            case "Discover":{
                if (Find.Object("ltCardTypeLt_AAF").isPresent()){
                    Report.pass("User Enters Discover Credit Card");
                    Find.Object("ltCardTypeLt_AAF").select(2);
                    Find.Object("ltCcNumber_AAF").input(cardNumber);
                    Find.Object("ltPapCardHolderName_AAF").input(cardHolderName);
                }else{
                    Report.fail("Discover Credit card is NOT available");
                }
                break;
            }
            case "MasterCard":{
                if(Find.Object("ltCardTypeLt_AAF").isPresent()){
                    Report.pass("User Selects Mastercard");
                    Find.Object("ltCardTypeLt_AAF").select(3);
                    Find.Object("ltCcNumber_AAF").input(cardNumber);
                    Find.Object("ltPapCardHolderName_AAF").input(cardHolderName);
                }else{
                    Report.fail("MasterCard is NOT available");
                }
                break;
            }

            case "Visa":{
                if(Find.Object("ltCardTypeLt_AAF").isPresent()){
                    Report.pass("User Selects Visa Card");
                    Find.Object("ltCardTypeLt_AAF").select(4);
                    Find.Object("ltCcNumber_AAF").input(cardNumber);
                    Find.Object("ltPapCardHolderName_AAF").input(cardHolderName);
                }else{
                    Report.fail("Visa Card is NOT available");
                }
                break;
            }
            case "American Express":{
                if(Find.Object("ltCardTypeLt_AAF").isPresent()){
                    Report.pass("User Selects the Amex Card");
                    Find.Object("ltCardTypeLt_AAF").select(5);
                    Find.Object("ltCcNumber_AAF").input(cardNumber);
                    Find.Object("ltPapCardHolderName_AAF").input(cardHolderName);
                }else{
                    Report.fail("Amex card is NOT available");
                }
                break;
            }

            default: {
                Report.dataFail("There is NO available Credit Card");
                break;
            }
        }

    }

    @Override
    public void AddGiftcard(String string, String string2) throws Exception {

        if(Find.Object("ltPapGcNum_AAF").isPresent() && Find.Object("ltPapGcPin_AAF").isPresent()){
            Report.pass("User Enters Card Number And Pin Number");
            Find.Object("ltPapGcNum_AAF").input(string);
            Find.Object("ltPapGcPin_AAF").input(string2);
            Find.MultipleObjects("parent_AAF").select(1).storeAs("temp");
            Use.CapturedObject("temp").FindObject("ltGcApplyBtn_AAF").click();
            //Find.Object("ltGcApplyBtn_AAF").click();
        }
    }

}


