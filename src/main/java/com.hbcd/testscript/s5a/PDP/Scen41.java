package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

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
