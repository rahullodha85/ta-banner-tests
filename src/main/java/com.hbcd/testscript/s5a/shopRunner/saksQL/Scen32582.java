package com.hbcd.testscript.s5a.shopRunner.saksQL;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32582  extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        prp.clickFirstItem();
        pdp.AddToBag();
        Thread.sleep(2000);
        pdp.EnterBag();
        ValidateBag.topBannerShopRunnerSigninlearnMore();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();
        bag.ClickEditFor(dataObject.getSkuListInfo().get(0));
        ValidateQL.HasNoShopRunnerIconDisplayedQl();

    }
}
