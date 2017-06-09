package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 8/23/2016.
 * This Class is created for the validations of various features related to LT
 */
public class ValidateReviewAndSubmitPage {

    public static void isSignatureRemoved() throws Exception{

        if (!Find.Object("ltRsRemovedSignature_AAF").getText().value().contains("Signature Required")){
            Report.pass("User Does NOT need to check the Required Signature");
        }else{
            Report.fail("Signature Required field is Displayed");
        }
    }

    public static void isSignatureRequiredForShippingMethods(String shippingMethods) throws Exception{

        switch (shippingMethods){
            case "Standard": {
                if (Find.Object("ltRsShpmtdStandard_AAF").isPresent()){
                    Report.pass("User Selects the Standard Shipping Method");
                    Find.Object("rsShpmtdStandard_AAF").click();
                }else {
                    Report.fail("Standard Shipping Method is NOT displayed");
                }
                break;
            }
            case "Rush":{
                if(Find.Object("ltRsShpmtdRush_AAF").isPresent()){
                    Report.pass("User Selects the Rush Shipping Method");
                    Find.Object("ltRsShpmtdRush_AAF").click();
                }else{
                    Report.fail("Rush Shipping Method is NOT displayed");
                }
                break;
            }
            case "Next Bus. Day":{
                if (Find.Object("ltRsShpmtdNextBusDay_AAF").isPresent()){
                    Find.Object("ltRsShpmtdNextBusDay_AAF").click();
                    Report.pass("User Selects the Next Bus. Day Shipping Method");
                }else{
                    Report.fail("Next Bus. Day is NOT displayed");
                }
                break;
            }
            case "Saturday":{
                if(Find.Object("ltRsShpmtdSaturday_AAF").isPresent()){
                    Report.pass("User Selects the Saturday Shipping Methods");
                    Find.Object("ltRsShpmtdSaturday_AAF").click();
                }else{
                    Report.fail("Saturday Shipping Method is NOT displayed");
                }
            }
            break;
            default: {
                Report.fail("No Shipping Method is Displayed");
                break;
            }
        }

    }

    public static void isMultiAddressRemovedRs() throws Exception{

        if (!Find.Object("ltRsMutltiAddressShipRemoved_AAF").getText().value().contains("Multiple Shipping")){
            Report.pass("Multi Address Shipping is NOT displayed");
        }else{
            Report.fail("Multi Address Shipping is Displayed");
        }
    }

    public static void isSignatureNotRequired() throws Exception{
        if (!Find.Object("ltRsSignatureNotRequired_AAF").getText().value().contains("Signature")){
            Report.pass("User does NOT Require to provide the Signature for items by the time of delivery");
        }else{
            Report.fail("Signature Require field is visibile");
        }
    }

    public static void isDisplayForThreeCountriesAvailable(String country) throws Exception{
        if (Find.Object("ltjsBillingCtryDpdown_AAF").isPresent()){
            Report.pass("User Can able to See Three Countries in the Drop Down");
            switch (country){
                case "United States": {
                    if(Find.Object("ltjsBillingCtryDpdown_AAF").isPresent()){
                        Report.pass("User Selects " + country);
                        Find.Object("ltjsBillingCtryDpdown_AAF").select(country);
                    }else{
                        Report.fail("Selected Country is NOT available in the dropdown");
                    }
                    break;
                }
                case "Canada": {
                    if (Find.Object("ltjsBillingCtryDpdown_AAF").isPresent()){
                        Report.pass("User Selects " + country);
                        Find.Object("ltjsBillingCtryDpdown_AAF").select(country);
                    }else{
                        Report.fail("Selected Country is NOT available in the dropdown");
                    }
                    break;
                }
                case "United Kingdom": {
                    if (Find.Object("ltjsBillingCtryDpdown_AAF").isPresent()){
                        Report.pass("User Selects " + country);
                        Find.Object("ltjsBillingCtryDpdown_AAF").select(country);
                    }else{
                        Report.fail("Selected Country is NOT available in the dropdown");
                    }
                    break;
                }
                default: {
                    Report.dataFail("There is not Three Countries available in the Country Dropdown Box");
                    break;
                }
            }
        }
    }
}
