package com.hbcd.testscript.commonplatform_mobile.MiniBag.B17033;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 12/19/2016.
 */
public class TC02 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Dress");
        prp.clickFirstItem();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.closeMiniBag();
        pdp.ValidatePDPPresent();
    }
}

