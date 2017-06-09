package com.hbcd.testscript.commonplatform.MiniBag.B19743;

        import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/15/2017.
 */
public class TC02 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.ClickSignInLink();
        sip.IsSignInPage();
        sip.IsSignInPage();
        sip.LoginWith("test333@test.com", "test333");
        accSum.IsSummaryPage();
        //miniBagOverlay.isMiniBagOpen();
        miniBagOverlay.clickMiniBag();
        miniBagOverlay.clickSaveForLater();
    }

}
