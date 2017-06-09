package com.hbcd.testscript.s5a.o5mDeltaStories.bogos;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 4/8/2016.
 * [QA] Promos- Free Ship (threshold and coupon code)
 */
public class ScenB15025_S2 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.EnterQuantity(2);
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.hasBuyOneGetOnePromoDisplayed("BUY 1 G 1 FREE");
        bag.ApplyPromo(dataObject.getPromo());
        ValidateBag.hasPromoCodeDisplayed();
        ValidateBag.hasSubTotalPriceChangedByPromo();

    }
}
