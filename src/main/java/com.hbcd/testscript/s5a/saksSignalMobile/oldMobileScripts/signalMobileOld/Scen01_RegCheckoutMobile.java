package com.hbcd.testscript.s5a.saksSignalMobile.oldMobileScripts.signalMobileOld;


import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class Scen01_RegCheckoutMobile extends ScenarioMobileSaks{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0438386556826");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("testc1@test.com", "123456ab");

        //Sometimes go to Billing Page
        //Sometimes go directly to PlaceOrder Page <-- correct way
        if (Find.Object("rsPlaceOrderBtn").isNotPresent()) {
            //In Billing Page - Move forward (click on next button)
            rsp.ClickNextOnMobile();
        }

        rsp.ClickPlaceOrder();
        String orderNumber = Find.Object("orderId_AAF").getText().value();
        Report.pass(orderNumber);
        Thread.sleep(30000);  //30 seconds
    }
}
