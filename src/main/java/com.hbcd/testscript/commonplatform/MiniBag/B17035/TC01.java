package com.hbcd.testscript.commonplatform.MiniBag.B17035;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/15/2017.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Dress");
        prp.clickFirstItem();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.clickOnItem();
        pdp.ClickQtyIncrement();
        pdp.AddToBag();
        miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.numberOfItems();
    }
}