package com.hbcd.testscript.s5a.PDP;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen06 extends ScenarioCommonPlatform {
    //csr item: take costly cartier item
    //please call message validate
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("cartierWatches").value());
        ValidateAemPdp.isCsrItem();
    }
}