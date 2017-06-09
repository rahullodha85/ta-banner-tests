package com.hbcd.testscript.off5th.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/14/2016.
 */
public class TC05_02 extends ScenarioCommonPlatform{
    @Override
    public void executeScript() throws Exception{
        nav.ClickTopNavLink("WOMEN");
        sec.ClickDresses();
        ValidateProductArray.isPageTitleByBrandName();
        sec.ClickJacketsAndVests();
    }
}
