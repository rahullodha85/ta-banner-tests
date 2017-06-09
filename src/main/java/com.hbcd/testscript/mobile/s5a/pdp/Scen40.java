package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen40 extends ScenarioCommonPlatform {
    //International Item: India currency displayed
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("India");
        nav.SearchFor(itemData.get(ItemType.REGULAR));
        ValidateAemPdp.hasIndiaCurrency();
    }
}
