package com.hbcd.testscript.commonplatform.pdp;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/21/2016.
 */
public class Scen22 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("item_colorsize").value());
        ValidatePdp.hasSizeColorOptionAvailable();
        ValidatePdp.hasSizeOptionsAvailable();
        pdp.AddToBag();
        pdp.EnterBag();

    }
}
