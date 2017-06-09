package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

/**
 * Created by aalfaruk on 4/11/2016.
 */
public class ScenB14966 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.hasOrderNumber();
    }
}
