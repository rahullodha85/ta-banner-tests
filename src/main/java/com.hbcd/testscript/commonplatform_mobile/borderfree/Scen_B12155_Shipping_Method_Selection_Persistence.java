package com.hbcd.testscript.commonplatform_mobile.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.banner.mobile.saks.pages.mProductDetailPage;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12155_Shipping_Method_Selection_Persistence extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


       /*
        GIVEN that I have changed a shipping method on the review and submit page
       Scenario: Changing the Shipping Method  (on Shipping Page)
GIVEN that I have selected a shipping method on the shipping page
WHEN the shipping method is displayed anywhere in the downstream UI (Payment and Review & Submit page)
THEN display the most recently selected shipping method

Scenario: Changing the Shipping Method  (on Review and Submit Page)
GIVEN that I have changed a shipping method on the review and submit page
WHEN I navigate back to the shipping page
THEN display the most recently selected shipping method

        */
        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");


        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");

        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getCity(), dataObject.getState(), "", true);
        shp.SelectShippingMethodInternational("DHL Express");
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();


        ValidateRs.hasShippingMethodUpdated("DHL Express");

        shp.SelectShippingMethodInternational("Standard");
        Navigate.back();
        Navigate.back();

        ValidateShipping.hasStandardShippingSelected();

        //***********
        /*
        GIVEN that I have selected a shipping method on the shipping page
        WHEN the shipping method is displayed anywhere in the downstream UI (Payment and Review & Submit page)
        THEN display the most recently selected shipping method
         */


    }
}


