package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/22/2016.
 */
public class Scen25 extends ScenarioCommonPlatform {
    //Validate Price Range and Promo Price and Strike Through Price in PDP,
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("struckOutWithPriceRange").value());
        ValidateAemPdp.hasPriceRange();
        ValidateAemPdp.hasStruckOutPrice();
    }
}
