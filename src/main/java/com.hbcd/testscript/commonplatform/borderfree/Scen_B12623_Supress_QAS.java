package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12623_Supress_QAS extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
            Scenario: Suppress QAS Validation (Shipping Address Page)
            GIVEN I have entered my address into the Shipping Address form
            WHEN I click the “CONTINUE CHECKOUT” button
            THEN suppress any QAS validation and proceed to the next step in the process

            Scenario: Suppress QAS Validation (Add/Edit Shipping Modal)
            GIVEN I have completed the Add/Edit Shipping Address form
            WHEN I click the “APPLY” button
            THEN suppress any QAS validation and proceed to the next step in the process

            Scenario: Suppress QAS Validation (Billing Address Modal)
            GIVEN I have entered my address into the Billing Address form
            WHEN I click the “APPLY” button
            THEN suppress any QAS validation and proceed to the next step in the process
      */

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");

        ValidateShippingBilling.hasShippingMethods("international");


        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        ValidateShippingBilling.hasNoQAS();
        //***************
        shp.ClickEditShippingAddress().fillNewShippingAddress("address","city","state","incorrect-zipcode");
        ValidateShippingBilling.hasNoQAS();

        shp.AddBillingAddress(dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        ValidateShippingBilling.hasNoQAS();
        //*********
        rsp.ClickShippingAndBillingTab();
        shp.ClickEditBillingAddress();

        shp.s5a_AddressOverlay().fillNewBillingAddress("address","city","state","zipcode");
        ValidateShippingBilling.hasNoQAS();
        //Click Cancel
        //******************





;    }
}


