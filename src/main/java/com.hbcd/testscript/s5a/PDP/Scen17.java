package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen17 extends ScenarioCommonPlatform {
//    UPC Sold Out in PDP Page
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("soldout").value());
        ValidateAemPdp.isSoldOut();
    }
}
