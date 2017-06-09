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
public class Scen_B12288_Canadian_Postal_Code_Validation_Edit_Shipping_Address_Page extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*

         Scenario: Provide a Prepopulated Province Dropdown
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        GIVEN that I navigate to the international shipping address edit page
        WHEN  the page loads
        THEN change the copy for the state field to say "Province"
        AND made the field a dropdown
        AND prepopulate the dropdown with all the Canadian provinces

        Scenario: Validate Postal Code Matches the Selected Province
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        GIVEN that I navigate to the international shipping address edit page
        WHEN I click the “APPLY” button
        THEN validate that the first digit of the postal code relates to the selected province

        Scenario: Validation Error Message
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        GIVEN that I navigate to the international shipping address edit page
        WHEN I click the “APPLY” button
        AND the validation fails
        THEN display the following error message per the existing Saks style guide: “Province and postal code do not match.”

        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");

        nav.ChangeCountry("India");
        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");



    }
}


