package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen17 extends ScenarioCommonPlatform {
//    UPC Sold Out in PDP Page
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("nonWaitlistableSoldout").value());
        ValidateAemPdp.isSoldOut();
    }
}
