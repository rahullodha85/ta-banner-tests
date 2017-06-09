package com.hbcd.testscript.s5a.shopRunner.saksQL;


import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32583 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(3000);
        pdp.selectSizeSwatch("1.7 OZ.");
        pdp.AddToBag();
        Thread.sleep(2000);
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        Thread.sleep(3000);
        bag.ClickEditFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(3000);
        ValidateQL.isShoprunnerNotDisplayonQl();
        Thread.sleep(3000);
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017", true);




    }

}
