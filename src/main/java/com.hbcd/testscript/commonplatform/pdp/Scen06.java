package com.hbcd.testscript.commonplatform.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen06 extends ScenarioCommonPlatform {
    //csr item: take costly cartier item
    //please call message validate
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0400087318373");
        ValidateAemPdp.isCsrItem();
    }
}