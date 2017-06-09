package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen31 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(itemData.get(ItemType.REGULAR));
        pdp.AddToBag(1);
        ValidateAemPdp.hasNumberOfItemsInOverlay("1");
        pdp.EnterBag();
    }
}
