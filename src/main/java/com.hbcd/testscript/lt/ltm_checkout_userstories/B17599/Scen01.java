package com.hbcd.testscript.lt.ltm_checkout_userstories.B17599;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateOrderDetails;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/1/2016.
 * Validate color and size showed for items in order details
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.HoverOverSignIn().ClickLinkFromDrawer("Order History");
        yap.AccessOrderStatus("1035000012", "10038");
        ValidateOrderDetails.isOrderDetailAvailable("1035000012", "10038");
    }

}
