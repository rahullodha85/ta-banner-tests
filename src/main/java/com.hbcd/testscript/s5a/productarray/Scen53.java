package com.hbcd.testscript.s5a.productarray;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen53 extends ScenarioChkout{
    //Saks Nightly: Excluded
    //lt script
    public void executeScript() throws Exception {
        nav.SearchFor("");
        nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
        //sec.ClickDresses();
        prp.RefineByColor("Black");
    }
}
