package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/8/2016.
 * Refine By color size price and designer
 */
public class TC02_47 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
        sec.ClickDresses();
        prp.RefineByLifeStyle("Lifestyle");
        prp.RefineByColor("Black");
        prp.RefineBySize("Medium");
        prp.RefineBy("Designer", "ABS");
        prp.RefineByPrice("$150 - $300");
        ValidateProductArray.hasClearAllPresent();
    }
}
