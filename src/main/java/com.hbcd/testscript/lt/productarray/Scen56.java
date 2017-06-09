package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;
import com.hbcd.testscript.lt.headerfooter.BottomNav;

public class Scen56 extends ScenarioChkout{
    //lt script
    //Saks Nightly: Excluded
    public void executeScript() throws Exception {
        nav.SearchFor("");
        nav.ClickStores();
        ValidateHome.hasBottomNavLt();

    }
}
