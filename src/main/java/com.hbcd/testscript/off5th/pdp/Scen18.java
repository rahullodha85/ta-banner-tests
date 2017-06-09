package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen18 extends ScenarioCommonPlatform {
//    Item Available in PDP Page

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("regular").value());
        ValidateAemPdp.isAvailable();
    }
}
