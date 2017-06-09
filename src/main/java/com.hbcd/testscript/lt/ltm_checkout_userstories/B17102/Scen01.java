package com.hbcd.testscript.lt.ltm_checkout_userstories.B17102;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateOrderDetails;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 9/30/2016.
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.HoverOverSignIn().ClickLinkFromDrawer("Order History");
        yap.AccessOrderStatus("1025000041", "10017");
        ValidateOrderDetails.isOrderDetailAvailable("1025000041", "10017");
    }
}
