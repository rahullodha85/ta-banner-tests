package com.hbcd.testscript.s5a.o5mDeltaStories.bogos;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 4/7/2016.
 * Backlog Item B-15027: [QA] Promos- % off
 */
public class ScenB15027 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.EnterQuantity(2);
        pdp.AddToBag();
        pdp.EnterBag();
        ValidateBag.hasBuyOneGetOnePromoDisplayed("BUY 1 G 1 FREE");
        bag.ApplyPromo(dataObject.getPromo());
        ValidateBag.hasPromoCodeDisplayed();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        ValidateShippingBilling.isBuyOneGetOneMessagePresent("BUY 1 G 1 FREE");
    }
}
