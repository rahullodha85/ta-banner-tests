package com.hbcd.testscript.mobile.off5th;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen40 extends ScenarioCommonPlatform {
    //International Item: India currency displayed
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("India");
        nav.SearchFor(InputData.get("indiaException").value());
        ValidateAemPdp.hasIndiaCurrency();
    }
}
