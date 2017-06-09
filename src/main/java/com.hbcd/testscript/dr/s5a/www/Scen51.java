package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by 461967 on 1/7/2016.
 */
public class Scen51 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception{
        nav.SearchFor("0402284270900");
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        nav.SearchFor("0457142487501");
        ValidatePdp.hasNoShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith("anne_bacay@s5a.com", "qatest123");
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");
    }
}
