package com.hbcd.testscript.lt.ltm_checkout_userstories.B18963;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateOrderDetails;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 9/20/2016.
 * B-18963
 * S1: legacy orders
 GIVEN I am a LT domestic user (registered or guest)
 AND I have placed an order in legacy website with CC as payment method
 WHEN I retrieve details of my order
 THEN I see my CC brand (Visa, Mastercard, American Express, Discover or LT), masked number with last 4 digits being displayed and expiration date.
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.HoverOverSignIn().ClickLinkFromDrawer("Order History");
        yap.AccessOrderStatus("1035000012", "10038");
        ValidateOrderDetails.isOrderDetailAvailable("1035000012", "10038");
        ValidateOrderDetails.hasCreditCardWithNumber();
    }
    
}
