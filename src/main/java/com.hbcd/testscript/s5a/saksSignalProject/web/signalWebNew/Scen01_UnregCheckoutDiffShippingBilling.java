package com.hbcd.testscript.s5a.saksSignalProject.web.signalWebNew;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

/**
 * Signal Project: order has 1 item with different billing and shipping address
 * Unregistered Checkout Web
 */
public class Scen01_UnregCheckoutDiffShippingBilling extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
        shp.ClickCheckoutOptionalAddressConfirmation();
        pap.AddNewCreditCard(3);//mastercard
        pap.EnterPassword("test123", "test123");
        pap.ClickCheckout();
        shp.ClickEditBillingAddress();
        shp.AddBillingAddress("14 E 49 street", "New York", "New York", "10017", false);
        shp.ClickCheckoutOptionalAddressConfirmation();
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        Switch.toDefaultContent();
        String orderInfo = Find.Object("confOrderNumMsg").getText().value();
        Report.pass(orderInfo);
        Thread.sleep(30000);  //30 seconds
    }

}
