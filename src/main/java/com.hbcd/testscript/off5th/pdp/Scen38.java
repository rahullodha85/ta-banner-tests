package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen38 extends ScenarioCommonPlatform {
    //sold out and non waitlistable
    // - showing sold out message
    // - not showing Add to Bag
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("nonWaitlistableSoldout").value());
        ValidateAemPdp.isSoldOut();
        ValidateAemPdp.noAddToBag();
    }
}
