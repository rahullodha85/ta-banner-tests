package com.hbcd.testscript.commonplatform.MiniBag.B19572;

        import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by yalipova on 1/15/2017.
 */
public class TC01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Jeans");
        prp.ClickFirstQuickLook();
        qlo.AddToBag(1);
        miniBagOverlay.isMiniBagOpen();
    }
}
