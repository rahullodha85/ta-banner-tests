package com.hbcd.testscript.s5a.omsService;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

/**
 * Created by aalfaruk on 5/26/2016.
 * Single line, Multi quantity
 */
public class Scen02 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.EnterQuantity(5);
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        Switch.toDefaultContent();
        String orderInfo = Find.Object("confOrderNumMsg").getText().value();
        Report.pass(orderInfo);
        Thread.sleep(30000);  //30 seconds
    }
}
