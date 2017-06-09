package com.hbcd.testscript.s5a.saksSignalProject.web.signalWebOld;


import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class Scen01_UnregPromoCheckout extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ApplyPromo(dataObject.getPromo());
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        String orderInfo = Find.Object("confOrderNumMsg").getText().value();
        Report.pass(orderInfo);
        Thread.sleep(3000);
    }

}
