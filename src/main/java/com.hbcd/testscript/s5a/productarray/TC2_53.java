package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/7/2016.
 */
public class TC2_53 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(" ");
        nav.ClickNavigationLinks(TopNavLinks.SHOES);
        ValidateProductArray.leftNavText("SHOES");
        sec.ClickShopAll();
        prp.ClickFirstItem();
        ValidatePdp.hasUserlandedOnPDPPage();
    }
}
