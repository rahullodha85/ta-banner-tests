package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen18 extends ScenarioCommonPlatform {
//    Item Available in PDP Page

    @Override
    public void executeScript() throws Exception {
        String regularItem = itemData.get(ItemType.REGULAR);

        nav.SearchFor(regularItem);
        ValidateAemPdp.isAvailable();
    }
}
