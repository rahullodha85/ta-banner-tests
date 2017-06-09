package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by 901124 on 1/7/2016.
 */
public class Scen56 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        String item1 = itemData.get(ItemType.REGULAR);
        String item2 = itemData.get(ItemType.REGULAR);
        String item3 = itemData.get(ItemType.REGULAR);
        String item4 = itemData.get(ItemType.REGULAR);

        nav.SearchFor(item1);
        pdp.AddToBag(1);
        nav.SearchFor(item2);
        pdp.AddToBag(1);
        nav.SearchFor(item3);
        pdp.AddToBag(1);
        nav.SearchFor(item4);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");
        shp.AddShippingAddress(false, "12 east 49th st", "New York", "New York", "10017", false);
        pap.AddNewCreditCard(3);//mastercard
        pap.EnterPassword("test123", "test123");
        pap.ClickCheckout();
        rsp.ClickShipToMultipleAddresses();
        rsp.EnterNewShippingAddress(item1, "12 East 49 street", "NEW YORK", "New York", "10017", true);
        shp.SelectRequireSignatureFor(item1);
        rsp.EnterNewShippingAddress(item2, "36 RTE 306", "Suffern", "New York", "10970", true);
        shp.SelectRequireSignatureFor(item2);
        shp.ClickContinueAfterMultiShip();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.hasSignatureRequiredAtDelivery(item2);
        ValidateConfirmation.hasNoSignatureRequiredAtDelivery(item1);
        ValidateConfirmation.ShippingAddressContains("12 East 49 street");


    }
}
