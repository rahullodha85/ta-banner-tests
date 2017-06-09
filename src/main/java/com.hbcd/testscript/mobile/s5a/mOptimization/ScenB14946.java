package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

/**
 * Created by 901124 on 3/21/2016.
 */
public class ScenB14946 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);

        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("claudiasosa" + Common.getUniqueNumber() + "@s5a.com");
        ValidateShipping.hasStepTwoActive();
        ValidateShipping.hasStepThreeActive();


    }
}