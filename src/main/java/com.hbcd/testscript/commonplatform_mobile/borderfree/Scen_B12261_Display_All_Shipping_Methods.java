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
public class Scen_B12261_Display_All_Shipping_Methods extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


       /*
    Scenario: Display All Available Shipping Methods
    (Reference notation #2 in attachment: International_ShippingPage_Mobile_ToBe.png)
    GIVEN that I’m an international customer on the shipping page
    WHEN the page loads
    THEN display all available shipping methods
    AND give me the option to pay my duties and taxes now or upon delivery
        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");

        nav.ChangeCountry("India");
        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        ValidateShipping.hasShippingMethods(3);
        ValidateShipping.hasOptionDutyFreeAndTaxes();


    }
}


