package com.hbcd.testscript.commonplatform.MiniBag.B19743;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/14/2017.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.LoginWith("test555@test.com", "test555");
        accSum.IsSummaryPage();
        //miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.clickMiniBag();
        miniBagOverlay.clickSaveForLater();
    }
}
//pdp.AddToBag();
  //      miniBagOverlay.isMiniBagOpen();
    //    miniBagOverlay.clickOnItem();


