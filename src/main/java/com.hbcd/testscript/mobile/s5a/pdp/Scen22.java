package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/21/2016.
 */
public class Scen22 extends ScenarioCommonPlatform {
    //size and color available
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("multipleColorAndSize").value());

        ValidateAemPdp.hasSizeSection();
        ValidateAemPdp.hasColorSection();
        pdp.AddToBag();
    }
}
