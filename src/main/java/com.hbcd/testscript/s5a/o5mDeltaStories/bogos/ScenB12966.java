package com.hbcd.testscript.s5a.o5mDeltaStories.bogos;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by 901124 on 4/6/2016.
 */
public class ScenB12966 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasBogoDisplayedOnPdp("Buy One Get One Free");
        pdp.EnterQuantity(2);
        pdp.AddToBag();
        ValidateBag.hasItemPromoMessageDisplayedBagPage("BUY 1 G 1 FREE");
    }
}