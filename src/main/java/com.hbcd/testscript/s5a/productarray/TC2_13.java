package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/4/2016.
 * Clickable Brand Links
 */
public class TC2_13 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception{
        nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
        nav.SelectDesigner("3.1 Phillip Lim");
        prp.ClickFirstQuickLook();
        ValidateQL.isQLViewProductDetailLink();
        ValidateQL.hasBrandLinkNameOnQL();
        ValidateProductArray.hasLeftNavLinks();
        prp.ClickFirstItem();
        ValidatePdp.hasUserlandedOnPDPPage();
    }
}
