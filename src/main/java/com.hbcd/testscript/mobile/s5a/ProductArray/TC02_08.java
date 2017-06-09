package com.hbcd.testscript.mobile.s5a.ProductArray;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.SortOptions;

/**
 * Created by aalfaruk on 12/8/2016.
 */
public class TC02_08 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor("Women");
        prp.SortBy(SortOptions.PRICE_LOWTOHIGH);
        prp.RefineByPrice("$300 - $500");
        ValidatePrp.isFirstItemPriceRange(300,500);//validate if item price falls under the price range
        prp.ClickFirstItem();
        ValidateAemPdp.isPDP();
    }

}
