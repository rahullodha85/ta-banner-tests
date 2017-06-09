package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/4/2016.
 * Cartidges Search Page
 */
public class TC2_08 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
        sec.ClickDresses();
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.RefineByPrice("$300 - $500");
        ValidateProductArray.hasBreadcrumbTitleAppeared("Dresses");
    }
}
