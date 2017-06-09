package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen30 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0400088613091");
        ValidatePdp.haspromoMoremessageOnFooter();
        pdp.AddToBag();
        pdp.EnterBag();
    }
}
