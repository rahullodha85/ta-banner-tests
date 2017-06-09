package com.hbcd.testscript.commonplatform_mobile.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.banner.mobile.saks.pages.mProductDetailPage;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12161_Canadian_Postal_Code_Validation extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


       /*
        Scenarios
        Scenario: Provide a Prepopulated Province Dropdown
        (Reference notation #1 in attachment: International_ShippingPage_ToBe.jpg)
        GIVEN that I navigate to the international shipping page
        WHEN  the page loads
        THEN change the copy for the state field to say "Province"
        AND prepopulate with all the Canadian provinces

        Scenario: Validate Postal Code Matches the Selected Province
        (Reference notation #10 in attachment: International_ShippingPage_mobile_ToBe.jpg)
        GIVEN that I navigate to the international shipping page
        WHEN I click the “CONTINUE CHECKOUT” button
        THEN validate that the first digit of the postal code relates to the selected province

        Scenario: Validation Error Message
        (Reference notation #4 in attachment: International_ShippingPage_mobile_ToBe.jpg)
        GIVEN that I navigate to the international shipping page
        WHEN I click the “CONTINUE CHECKOUT” button
        AND the validation fails
        THEN display the following error message per the existing Saks style guide: “Province and postal code do not match.”
        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");


        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        ValidateShipping.hasRegionProvinceField("canada");
        ValidateShipping.hasCanadaProvinceList();
        //***********
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);

        ValidateShipping.hasNotMatchingZipCodeAndProvince();
        //***********
        //Navigate.back();
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        ValidateShipping.hasMatchingZipCodeAndProvince();


    }
}


