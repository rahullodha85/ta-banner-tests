package com.hbcd.testscript.lt.ltm_checkout_userstories.B18201;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
/**
 * Created by aalfaruk on 9/6/2016.
 * B-18201
 * [QA] L&TM: Verify International Order Processing
 * S1: I can view order history for my international orders
 GIVEN I have placed an international order
 WHEN I view my order history
 THEN I will see the international order in my order history
 AND I can view the order details
 */
public class Scen01 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("Canada");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
    }
}
