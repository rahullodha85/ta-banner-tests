package com.hbcd.testscript.mobile.off5th;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen14 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("multPrice").value());
        ValidateAemPdp.hasMultiplePrices();
    }
}