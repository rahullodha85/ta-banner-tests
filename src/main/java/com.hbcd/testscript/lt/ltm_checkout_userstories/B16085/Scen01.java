package com.hbcd.testscript.lt.ltm_checkout_userstories.B16085;

import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/4/2016.
 */
public class Scen01 extends ScenarioCommonPlatform{
    @Override
    public void executeScript() throws Exception{
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.MakeGift(item1).With("Hello From Automation Engineers");
    }
}
