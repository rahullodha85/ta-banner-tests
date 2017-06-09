package com.hbcd.testscript.s5a.saksSignalProject.web.signalWebOld;


import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

public class Scen01_UnregCheckout extends ScenarioChkout {

    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
		nav.SearchFor(item1);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        Switch.toDefaultContent();
        String orderInfo = Find.Object("confOrderNumMsg").getText().value();
        Report.pass(orderInfo);
        Thread.sleep(30000);  //30 seconds
    }
}
