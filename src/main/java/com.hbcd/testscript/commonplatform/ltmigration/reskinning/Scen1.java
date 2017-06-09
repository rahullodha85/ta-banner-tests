package com.hbcd.testscript.commonplatform.ltmigration.reskinning;

import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class Scen1 extends ScenarioSaks {

    public void executeScript() throws Exception {
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.REGULAR);*/
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        nav.SearchFor(dataObject.getSkuListInfo().get(1));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID());
        ValidateShippingBilling.hasUserlandedOnShippingAndBilling("Shipping & Billing");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(),
                dataObject.getCity(), dataObject.getZipCode(), false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
//        rsp.ClickPlaceOrder();
//        ValidateConfirmation.isThankYouPage();

    }
}
