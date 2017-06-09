package com.hbcd.testscript.mobile.s5a.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen06 extends ScenarioCommonPlatform {
    //csr item: take costly cartier item
    //please call message validate
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("cartierWatches").value());
        ValidateAemPdp.isCsrItem();
    }
}