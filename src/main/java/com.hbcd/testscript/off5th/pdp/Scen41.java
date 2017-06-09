package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen41 extends ScenarioCommonPlatform {
    //Standard gift card: denominations showing
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("standardGiftCard").value());
        ValidateAemPdp.hasGiftCardDenominations();
    }
}
