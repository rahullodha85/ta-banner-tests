package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;

/**
 * Created by aalfaruk on 1/3/2017.
 */
public class TC01_AnyLinks extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ClickBrandsDrawer();
        sec.ClickDresses();
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.RefineByPrice("$300 - $500");
        ValidateProductArray.isFirstItemPriceRange(300,500);
    }
}
