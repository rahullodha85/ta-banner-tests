package com.hbcd.testscript.lt.ltm_checkout_userstories.B16019;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidatePaymentPage;
import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateShippingAndBilling;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 8/29/2016.
 * L&TM: ShopRunner Placements (Bag & Checkout)
 * S2: The ShopRunner top banner has been removed from checkout
 GIVEN I have added an item to my bag
 AND The top banner has been removed from all checkout screens
 WHEN I click through check out
 THEN I will not see the ShopRunner top banner on the Shipping & Billing, Payment, or Review & Submit screens
 */
public class Scen02 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingAndBilling.isShopRunnerTopBannerRemovedShippingAndBilling();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        ValidatePaymentPage.isShoprunnerTopBannerRemoved();






    }
}
