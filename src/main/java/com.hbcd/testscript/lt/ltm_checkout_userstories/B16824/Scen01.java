package com.hbcd.testscript.lt.ltm_checkout_userstories.B16824;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateOrderDetails;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by 901124 on 6/29/2016.
 * L&TM: Display Details for Guest Orders
 * S1: As a guest, I look up the details of my order
 GIVEN I have placed a domestic order as a guest
 WHEN I select 'Order History' from the account pulldown menu
 AND I enter my order number and zipcode
 THEN I can view the details of my order
 */
public class Scen01 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.HoverOverSignIn().ClickLinkFromDrawer("Order History");
        yap.AccessOrderStatus("1005000034", "10017");
        ValidateOrderDetails.isOrderDetailAvailable("1005000034", "10017");
    }
}