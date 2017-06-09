package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen27 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("India");
        nav.SearchFor(InputData.get("indiaException").value());
        ValidateAemPdp.hasIndiaCurrency();
    }
}
