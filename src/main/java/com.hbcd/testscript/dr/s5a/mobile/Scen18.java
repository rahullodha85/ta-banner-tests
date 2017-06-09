package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by 461967 on 1/7/2016.
 */
public class Scen18 extends ScenarioMobileSaks {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("Gucci, Shoes");
        ValidatePrp.isBrandPage("Gucci");
    }
}
