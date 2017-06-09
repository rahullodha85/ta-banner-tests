package com.hbcd.testscript.s5a.paypal;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen01 extends ScenarioPaypal {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(itemData.get(ItemType.REGULAR));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("testc1@test.com", "123456ab");
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
        Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
        yap.Go();
        //yap.Login("testc1@test.com", "123456ab");
        yap.AccessOrderStatus(Storage.get("orderNumber"), "10017");
        // fixme: move from o5a  ValidateYap.hasPaypalPayment();
    }
}
