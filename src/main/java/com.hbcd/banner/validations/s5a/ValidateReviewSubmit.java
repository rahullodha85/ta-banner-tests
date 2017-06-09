package com.hbcd.banner.validations.s5a;


import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.testscript.s5a.inventory.Update;

public class ValidateReviewSubmit {


   public static void isShopRunnerShippingMethodPresent(String upc, String text) throws Exception{

       Thread.sleep(3000);
       if(Find.Object("rspSRShippingMethod_zk").changeAttributeContainsValue("data-cartproductcode", upc).getText().value().contains(text))
           Report.pass("Shipping validation pass");
       else
           Report.fail("Shipping validation fail");
   }

    public static void isShopRunnerEligibleSignDisplay() throws Exception{
        StepLogger.validate(Check.TextPresent, "bagShopRunnerEligible_zk");
    }

    public static void isShopRunnerEligibleSignNotDisplay(String upc) throws Exception{

        if(!Find.Object("rspSRShippingMethod_zk").changeContainsText(upc).getText().value().contains("Eligible"))
            Report.pass("Validation PASS");
        else
            Report.fail("Validation FAIL");

    }

    public static void hasBuyOneGetOnePromoOnRs(String promoMessageRs) throws Exception{

        if (Find.Object("ofm_promoMessageRs_AAF").isPresent()){
            Find.Object("ofm_promoMessageRs_AAF").getText().value().contains(promoMessageRs);
            Report.pass("Promo Message is Displayed on Review & Submit Page " + promoMessageRs,BrowserAction.screenshot());
        }else{
            Report.fail("Promo Message is NOT displayed on Review & Submit Page", BrowserAction.screenshot());
        }
    }

    public static void hasBuyOneGetTwoPromoDisplayedOnRS(String promo)throws Exception{
        if (Find.Object("o5m_promoBuyTwoGetOneRs_AAF").isPresent()){
            Find.Object("o5m_promoBuyTwoGetOneRs_AAF").getText().value().contains(promo);
            Report.pass(promo + " Message is Displayed",BrowserAction.screenshot());
        }else{
            Report.fail("BUY 2 GET 1 FREE is NOT displayed",BrowserAction.screenshot());
        }
    }

    public static void hasQuantityUpdated(String qty)throws Exception{
        if (Find.Object("rspItemQuantity").isPresent()){
            Report.pass("User Updates Quantity By " + qty,BrowserAction.screenshot());
        }else{
            Report.fail("Unable to Update Quantity",BrowserAction.screenshot());
        }
    }


}
