package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen39 extends ScenarioCommonPlatform {
    //International Restriction: item can't be shipped
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("India");
        nav.SearchFor(InputData.get("indiaException").value());
        ValidateAemPdp.hasShippingRestrictionMsg();
    }
}
