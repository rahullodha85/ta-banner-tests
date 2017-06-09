package com.hbcd.testscript.s5a.shopRunner.saksBag;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen32593 extends ScenarioChkout {

    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(2);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();


    }
}
