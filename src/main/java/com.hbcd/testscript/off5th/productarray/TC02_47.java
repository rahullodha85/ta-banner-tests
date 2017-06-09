package com.hbcd.testscript.off5th.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/14/2016.
 */
public class TC02_47 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ClickTopNavLink("WOMEN");
        prp.RefineByLifeStyle("Lifestyle");
        prp.RefineByColor("Black");
        prp.RefineBySize("Medium");
        prp.RefineBy("Designer", "ABS");
        prp.RefineByPrice("$150 - $300");
        ValidateProductArray.hasClearAllPresent();
    }
}
