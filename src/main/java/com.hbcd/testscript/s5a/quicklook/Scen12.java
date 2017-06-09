package com.hbcd.testscript.s5a.quicklook;

import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;

public class Scen12 extends ScenarioSaks {

    //Checkout - Quick look overlay validation
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickEditFor("0400088413678");
        ValidateQL.Overlay();
    }

}
