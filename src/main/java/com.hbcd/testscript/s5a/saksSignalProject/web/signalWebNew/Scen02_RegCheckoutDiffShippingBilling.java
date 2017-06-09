package com.hbcd.testscript.s5a.saksSignalProject.web.signalWebNew;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

/**
 * Signal Project: Registered Checkout with Different Shipping and Billing Addresses
 * Web Registered Checkout
 */
public class Scen02_RegCheckoutDiffShippingBilling extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        String item2 = dataObject.getSkuListInfo().get(1);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        nav.SearchFor(item2);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ApplyPromo("FREESHIP");
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        pap.ContinueCheckoutPaymentPage();
        shp.ClickEditBillingAddress();
        shp.AddBillingAddress("14 E 49 street", "New York", "New York", "10017", false);
        rsp.ClickPlaceOrder();
        Switch.toDefaultContent();
        String orderInfo = Find.Object("confOrderNumMsg").getText().value();
        Report.pass(orderInfo);
        Thread.sleep(30000);  //30 seconds

    }
}
