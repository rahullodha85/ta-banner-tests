package com.hbcd.testscript.lt.ltm_checkout_userstories.B17468;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateBagPage;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;

/**
 * Created by aalfaruk on 8/29/2016.
 * B-17468
 * L&TM: ShopRunner 2 Day FREE Shipping (Eligible Only)
 * For domestic checkout, we need to re-purpose the existing RUSH shipping method... So that signed-in ShopRunner members can receive free 2-Day shipping.
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith("saks-test@shoprunner.com", "test1234");
        shp.SelectShippingMethodFor(dataObject.getSkuListInfo().get(0), ShipMethod.RUSH);
        ValidateBagPage.isShoprunnerFreeshippingAvailable();


    }
}
