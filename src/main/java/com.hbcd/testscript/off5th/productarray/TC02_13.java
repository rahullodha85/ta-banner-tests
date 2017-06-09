package com.hbcd.testscript.off5th.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/14/2016.
 * Clickable Brand Links
 */
public class TC02_13 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ClickTopNavLink("WOMEN");
        prp.ClickFirstQuickLook();
        ValidateQL.isQLViewProductDetailLink();
        ValidateQL.hasBrandLinkNameOnQL();
        prp.ClickFirstItem();
        ValidatePdp.hasUserlandedOnPDPPage();
    }
}
