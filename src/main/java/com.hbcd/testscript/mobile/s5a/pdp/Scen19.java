package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen19 extends ScenarioCommonPlatform {
    //dropdown displays for items with > 9 sizes
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("dropdownEnabled").value());
        ValidateAemPdp.hasDropdown();
    }
}
