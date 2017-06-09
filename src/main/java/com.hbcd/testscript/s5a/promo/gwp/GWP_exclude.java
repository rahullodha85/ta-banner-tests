package com.hbcd.testscript.s5a.promo.gwp;

import com.hbcd.banner.validations.s5a.ValidatePromo;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.dataobjects.OrderSummary;

public class GWP_exclude extends ScenarioChkout {


    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        OrderSummary beforePromo = new OrderSummary();
        bag.ApplyPromoExpectFail(dataObject.getPromo());
    }
}
