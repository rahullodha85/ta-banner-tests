package com.hbcd.testscript.s5a.saksSignalProject.web.signalWebNew;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

/**
 * 10 Items
 */
public class Scen03_RegCheckoutTenItems extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(2));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(3));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(4));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(5));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(6));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(7));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(8));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(9));
        pdp.AddToBag(1);
        pdp.EnterBag();
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
