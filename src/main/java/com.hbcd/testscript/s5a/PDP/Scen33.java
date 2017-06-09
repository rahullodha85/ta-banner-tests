package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen33 extends ScenarioCommonPlatform {
    //brand redirects to DLP
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("chanel").value());
        ValidateAemPdp.chanelRedirect();
    }
}
