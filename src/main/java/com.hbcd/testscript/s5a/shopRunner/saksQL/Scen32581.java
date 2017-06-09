package com.hbcd.testscript.s5a.shopRunner.saksQL;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32581 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        //prp.clickFirstItem();
        //pdp.selectSizeSwatch("2 OZ.");
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        Thread.sleep(2000);
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignDisplay();
        bag.ClickEditFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(2000);
        ValidateQL.shopRunnerIconDisplayedQl();
    }


}
