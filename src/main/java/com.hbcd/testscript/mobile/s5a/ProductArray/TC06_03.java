package com.hbcd.testscript.mobile.s5a.ProductArray;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;

/**
 * Created by aalfaruk on 12/16/2016.
 */
public class TC06_03 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor("Women");
        prp.FilterByDesigner("3.1 Phillip Lim");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.ClickFirstItem();
        ValidateAemPdp.isPDP();
    }
}
