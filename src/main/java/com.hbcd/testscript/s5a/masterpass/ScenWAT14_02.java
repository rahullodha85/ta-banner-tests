package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 901124 on 12/7/16.
 */
public class ScenWAT14_02 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.hasMasterPassButton();
    }
}