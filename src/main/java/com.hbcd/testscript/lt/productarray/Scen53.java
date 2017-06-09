package com.hbcd.testscript.lt.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

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
