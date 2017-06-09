package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.base.ScenarioChkout;

public class IntShipFlag extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        ValidateNav.hasInternationalShippingLink();
    }
}
