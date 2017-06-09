package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/8/2016.
 * Search By Rootlevel
 */
public class TC02_56 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(" ");
        ValidateProductArray.hasShopByCategoryPresent();
    }
}
