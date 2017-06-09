package com.hbcd.testscript.commonplatform.MiniBag.B18864;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.overlays.MiniBagOverlay;

/**
 * Created by yalipova on 12/19/2016.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Dress");
        prp.clickFirstItem();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.clickOnItem();
    }
}
