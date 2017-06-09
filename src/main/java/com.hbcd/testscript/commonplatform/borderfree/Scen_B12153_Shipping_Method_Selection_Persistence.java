package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12153_Shipping_Method_Selection_Persistence extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
        Scenario: Changing the Shipping Method  (on Shipping Page)
        GIVEN that I have selected a shipping method on the shipping page
        WHEN the shipping method is displayed anywhere in the downstream UI (Payment and Review & Submit page)
        THEN display the most recently selected shipping method

        Scenario: Changing the Shipping Method  (on Review and Submit Page)
        GIVEN that I have changed a shipping method on the review and submit page
        WHEN I navigate back to the shipping page
        THEN display the most recently selected shipping method

        */

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");

        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);

        shp.SelectShippingMethodInternational("DHL Express");
        shp.ClickCheckoutOptionalAddressConfirmation();
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        //fill it
        rsp.SelectShippingMethodInternational("standard");
        Navigate.back();
        Navigate.back();
        Navigate.back();
        //fill it
        ValidateShippingBilling.hasShippingMethodUpdated("standard");


        //***************
        /*Scenario: Changing the Shipping Method  (on Review and Submit Page)
        GIVEN that I have changed a shipping method on the review and submit page
        WHEN I navigate back to the shipping page
        THEN display the most recently selected shipping method*/








    }
}


