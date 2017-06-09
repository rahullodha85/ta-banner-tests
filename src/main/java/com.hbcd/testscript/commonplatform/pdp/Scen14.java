package com.hbcd.testscript.commonplatform.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen14 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("item2").value());
        ValidateAemPdp.hasMultiplePrices();
    }
}