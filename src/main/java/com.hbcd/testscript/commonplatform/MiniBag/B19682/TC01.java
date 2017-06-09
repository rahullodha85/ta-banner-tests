package com.hbcd.testscript.commonplatform.MiniBag.B19682;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/15/2017.
 */
public class TC01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Boots");
        prp.clickFirstItem();
        pdp.EnterQuantity(30);
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.errorMessage();
    }
}
