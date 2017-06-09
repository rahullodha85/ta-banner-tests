package com.hbcd.testscript.s5a.saksSignalMobile.oldMobileScripts.signalMobileOld;


import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.helper.Common;

public class Scen01_UnregCheckoutMobile extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0438386556826");
        pdp.EnterQuantity(2);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("claudiasosa" + Common.getUniqueNumber() + "@s5a.com");
        shp.AddShippingAddress(true, "12 E 49th Street", "New York",
                "New York", "10017", true);
        pap.AddNewCreditCard(3, "test123", "test123");
        rsp.ClickPlaceOrder();
        String orderNumber = Find.Object("orderId_AAF").getText().value();
        Report.pass(orderNumber);
        Thread.sleep(30000);  //30 seconds
    }
}
