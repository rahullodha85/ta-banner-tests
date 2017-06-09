package com.hbcd.testscript.off5th.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;


/**
 * Created by aalfaruk on 11/11/2016.
 * Cartridges search page for Off5th
 */
public class TC02_08 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ClickTopNavLink("WOMEN");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.RefineByPrice("$300 - $500");
        ValidateProductArray.hasBreadcrumbTitleAppeared("Dresses");
    }

}
