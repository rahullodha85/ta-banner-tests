package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/7/2016.
 * Top Nav
 */
public class TC6_03 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.ClickNavigationLinks(TopNavLinks.SHOES);
        ValidateProductArray.leftNavText("SHOES");
        sec.ClickShopAll();
        sec.RefineBy("Designer","3.1 Phillip Lim");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.ClickFirstItem();
        ValidatePdp.hasUserlandedOnPDPPage();
    }


}
