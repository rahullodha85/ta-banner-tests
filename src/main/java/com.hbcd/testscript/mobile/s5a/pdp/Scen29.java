package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen29 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0400088613253");
        nav.SearchFor("0400088613091");
        pdp.AddToBag();
        ValidatePdp.recentlyViewdItem();
    }
}
