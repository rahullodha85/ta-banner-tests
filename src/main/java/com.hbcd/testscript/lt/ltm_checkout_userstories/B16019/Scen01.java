package com.hbcd.testscript.lt.ltm_checkout_userstories.B16019;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/29/2016.
 * B16019
 * L&TM: ShopRunner Placements (Bag & Checkout)
 * S1: L&T ShopRunner assets are being loaded (Sign-In/Learn More)
 GIVEN Blue Martini is pointing to the L&T ShopRunner assets
 AND I add an item to my bag
 WHEN I click 'Learn More' ShopRunner link on the bag screen
 THEN I will see the L&T logos and Image
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.ClickShoprunnerLearnMore();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
    }
}
