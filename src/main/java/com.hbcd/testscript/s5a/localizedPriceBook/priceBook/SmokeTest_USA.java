package com.hbcd.testscript.s5a.localizedPriceBook.priceBook;


import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class SmokeTest_USA extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();

    }

}
