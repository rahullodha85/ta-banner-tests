package com.hbcd.testscript.s5a.omsService;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

/**
 * Created by aalfaruk on 5/26/2016.
 * single line, single quantity
 */
public class Scen01 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        ValidateShippingBilling.hasUserlandedOnShippingAndBilling("Shipping & Billing");
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
