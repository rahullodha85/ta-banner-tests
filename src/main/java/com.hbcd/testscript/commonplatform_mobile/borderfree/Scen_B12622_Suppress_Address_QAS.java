package com.hbcd.testscript.commonplatform_mobile.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.banner.mobile.saks.pages.mProductDetailPage;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12622_Suppress_Address_QAS extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*
       Scenario: Suppress QAS Validation (Shipping Address Page)
        GIVEN I have entered my address into the Shipping Address form
        WHEN I click the “NEXT STEP” button
        THEN suppress any QAS validation and proceed to the next step in the process

        Scenario: Suppress QAS Validation (Billing Address Page)
        GIVEN I have entered my address into the Billing Address form
        WHEN I click the “NEXT STEP” button
        THEN suppress any QAS validation and proceed to the next step in the process

        Scenario: Suppress QAS Validation (Add Shipping Address Modal)
        GIVEN I have completed the Add Shipping Address form
        WHEN I click the “APPLY” button
        THEN suppress any QAS validation and proceed to the next step in the process

        Scenario: Suppress QAS Validation (Edit Shipping Address Modal)
        GIVEN I have completed the Edit Shipping Address form
        WHEN I click the “APPLY” button
        THEN suppress any QAS validation and proceed to the next step in the process

        Scenario: Suppress QAS Validation (Add Billing Address Modal)
        GIVEN I have entered my address into the Add Billing Address form
        WHEN I click the “APPLY” button
        THEN suppress any QAS validation and proceed to the next step in the process

        Scenario: Suppress QAS Validation (Edit Billing Address Modal)
        GIVEN I have entered my address into the Edit Billing Address form
        WHEN I click the “APPLY” button
        THEN suppress any QAS validation and proceed to the next step in the process
        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");

        nav.ChangeCountry("India");
        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getCity(), dataObject.getState(), "", false);
        shp.SelectShippingMethodInternational("DHL Express");

        


    }
}


