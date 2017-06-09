package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by vevinmoza on 9/14/16.
 */
public class ValidateNav {
    public static void hasChatLink() throws Exception{
        if(Find.Object("ltToolBar_vm").getText().value().toLowerCase().indexOf("chat")<=0){
            Report.pass("Chat Link not present");
        }
        else {
            Report.fail("Chat Link present");
        }
    }

    public static void hasPhoneNumber() throws Exception{
        if(Find.Object("ltToolBar_vm").getText().value().toLowerCase().indexOf("1.800.223.7440")>=0){
            Report.pass("Phone number is present");
        }
        else {
            Report.fail("Phone number is not present");
        }
    }

    public static void hasBag() throws Exception{
        if(Find.Object("ltToolBar_vm").getText().value().toLowerCase().indexOf("bag(0)")<=0){
            Report.pass("Bag(0) is present");
        }
        else {
            Report.fail("Bag(0) is not present");
        }
    }

    public static void isBrandContainerAvailable() throws Exception{
        if (Find.Object("ltDesignerContainer_AAF").isPresent()){
            Report.pass("User is Landed on the Brand-Designer Container");
        }else{
            Report.fail("Brand-Designer Container is NOT available");
        }
    }
}
