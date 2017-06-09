package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/22/2016.
 */
public class Scen23 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("fisEnabled").value());
//        ValidateAemPdp.hasFis("11435");
    }
}
