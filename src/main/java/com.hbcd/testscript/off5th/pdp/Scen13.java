package com.hbcd.testscript.off5th.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen13 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("singlePrice").value());
        ValidateAemPdp.hasSinglePrice();
    }
}