package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.scripting.core.Storage;

public class Scen52 extends ScenarioSaks{
    /*
   " Add 1 eligible item  and apply GWP promo on Bag and 1 regular item.
   Place order as unregistered user with Visa credit card as MOP.
   Check Thank You page, Print Receipt, Order History in Account Section
   Verify that QAS layer comes up when customer enters a new address
   Cancel the order from Account Section within 20 minuts"

   "* Order is placed successfully.
   * Promo is applied successfully
   * GWP item is added to bag successfully
   * QAS works
   * Estimated delivery date provided.
   * All totals are correct and  gift card is displayed on confirmation page.
   Everything in the Thank you page,  Print receipt and Account reads correctly."
    */
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0476971482418");
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("drScen23@saks.com", "test123");
        rsp.ClickPlaceOrder();
        Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
        yap.GoToMyAcccount().CancelOrder(Storage.get("orderNumber"), "10017");
    }
}

