package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/7/2016.
 */
public class TC5_02 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
     nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
     sec.ClickDresses();
     sec.RefineBy("Designer","3.1 Phillip Lim");
     prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
     prp.ClickFirstItem();
     ValidatePdp.hasUserlandedOnPDPPage();
    }
}
