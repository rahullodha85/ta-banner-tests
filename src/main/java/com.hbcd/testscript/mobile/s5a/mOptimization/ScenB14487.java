package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;


/**
 * Created by 901124 on 2/29/2016.
 */
public class ScenB14487 extends ScenarioMobileSaks {

    /*As a business, we want to present the user with the promo banners on the top of Saks bag page.*/
    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.hasPromoBanner();
        ValidateBag.hasShoprunnerBanner();
        ValidateBag.hasNoContinueShoppingLink();
    }
}