package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen34 extends ScenarioCommonPlatform {
    //no DLP brand redirects to shop all
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("noDLP").value());
        ValidateAemPdp.hasNoDLP();
    }
}
