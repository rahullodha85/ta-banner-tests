package com.hbcd.testscript.off5th.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;

/**
 * Created by aalfaruk on 11/16/2016.
 */
public class TC06_03 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.ClickTopNavLink("SHOES & BAGS");
        sec.ClickShopAll();
        sec.RefineBy("Designer","3.1 Phillip Lim");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.ClickFirstItem();
        ValidatePdp.hasUserlandedOnPDPPage();

    }
}
