package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by aalfaruk on 6/30/2016.
 * This class is created to keep all the validations related to LT BagPage
 * Since These are standalone, until we find a way to take out these Standlaone class, we will keep
 * all validations related to BagPage in this class.
 */
public class ValidateBagPage {

public static void isDefaultStandardShippingApplied(String upc) throws Exception{

    if (Find.Object("ltBagStdShippingRate_AAF").changeContainsText(upc).getText().value().contains("Standard"))
        Report.pass("Strandard Shipping method is Applied");
    else
        Report.fail("This item is NOT eligible for Standard Shipping");
    }

public static void isRushShippingDisplayedOnBag(String zip, String upc) throws Exception{

    Find.Object("ltBagRushShipping_AAF").select(2);
    Find.Object("ltBagZipCode_AAF").input(zip);
   if (Find.Object("ltBagRushShippingValidations_AAF").changeContainsText(upc).getText().value().contains("Rush"))
        Report.pass("Rush Shipping is Displayed");
    else
        Report.fail("Rush Shipping is NOT displayed");
    }

    public static void isMultiAddressShippingRemovedFromBag() throws Exception{
        if(!Find.Object("ltBagPage_AAF").getText().value().contains("Multi-Address Shipping")){
            Report.pass("Multi-Address Shipping is NOT available in the BagPage");
        }else{
            Report.fail("Multi-Address Shipping is Displayed on BagPage");
        }

    }

    public static void isShoprunnerFreeshippingAvailable() throws Exception{
        if (Find.Object("ltBagShoprunner_AAF").getText().value().contains("ShopRunner 2 Day FREE")){
            Report.pass("When User Signin the Shoprunner the RUSH Shipping Methods changed to ShopRunner 2 Day FREE shipping Method");
        }else{
            Report.fail("ShopRunner FREE Shipping Method is NOT available");
        }
    }

    public static void isExpressCheckOutBtnRemoved() throws Exception{
        if (!Find.Object("ltBagPageExpCheckBtn_AAF").getText().value().contains("Express UnRegisterCheckout")){
            Report.pass("Express UnRegisterCheckout Button for LT is Removed");
        }else{
            Report.fail("Express UnRegisterCheckout Buttion is Available");
        }

    }

    public static void isQuickLookDisabledOnBagPage() throws Exception{
        if (!Find.Object("ltBagQldisable_AAF").isPresent()){
            Report.pass("Quick Look is Disabled in Bag Page");
        }else{
            Report.fail("QuickLook is NOT disabled");
        }

    }


}
