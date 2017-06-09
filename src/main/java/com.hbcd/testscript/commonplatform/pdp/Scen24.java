package com.hbcd.testscript.commonplatform.pdp;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 5/22/2016.
 */
public class Scen24 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0400089162374");
        ValidatePdp.hasSizeColorOptionAvailable();
        ValidatePdp.hasSizeOptionsAvailable();
        ValidatePdp.hasSizeFirPredictorAvailableOnPDP();
        pdp.AddToBag();
        pdp.EnterBag();

    }
}