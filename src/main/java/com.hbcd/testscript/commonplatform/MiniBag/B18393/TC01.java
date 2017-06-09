package com.hbcd.testscript.commonplatform.MiniBag.B18393;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/5/2017.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Dress");
        prp.clickFirstItem();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.clickCheckout();
    }
}