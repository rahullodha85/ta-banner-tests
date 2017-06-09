package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen52 extends ScenarioChkout{
    //Saks Nightly: Excluded
    public void executeScript() throws Exception {
        nav.SearchFor(" ");

        prp.RefineBy("Brand", "1 Madison");
        ValidatePrp.hasSaksTag("1 Madison");
        //#js-pa-active-refinement
    }
}
