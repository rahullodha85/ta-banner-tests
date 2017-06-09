package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
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
