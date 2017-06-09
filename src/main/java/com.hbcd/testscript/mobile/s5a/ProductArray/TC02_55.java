package com.hbcd.testscript.mobile.s5a.ProductArray;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 12/16/2016.
 */
public class TC02_55 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{

        nav.SearchFor("3.1 Phillip Lim");
        ValidatePrp.isSearchByKeyAppearedOnPrp("Phillip Lim");
        prp.ClickFirstItem();
        ValidateAemPdp.isPDP();
    }
}
