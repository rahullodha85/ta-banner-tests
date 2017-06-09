package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;

public class SaksLogo extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        ValidateNav.hasLogo();
    }
}
