package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen37 extends ScenarioCommonPlatform {
    //PreOrder: displaying preorder label and message,
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(itemData.get(ItemType.PREORDER));
        ValidateAemPdp.hasReviewsTeaser();
    }
}
