package com.hbcd.testscript.mobile.s5a.ProductArray;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;

/**
 * Created by aalfaruk on 12/14/2016.
 */
public class TC02_47 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor("Women");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.RefineByPrice("$300 - $500");
        prp.FilterByDesigner("3.1 Phillip Lim");
        prp.RefineByLifeStyle("Lifestyle");
        prp.RefineByColor("Black");
        prp.ClickFirstItem();
        ValidateAemPdp.isPDP();
    }
}
