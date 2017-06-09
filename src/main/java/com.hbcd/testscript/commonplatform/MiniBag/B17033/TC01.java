package com.hbcd.testscript.commonplatform.MiniBag.B17033;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 12/12/2016.
 */
public class TC01  extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Jeans");
        prp.clickFirstItem();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
    }
}
