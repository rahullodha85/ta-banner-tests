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
public class Scen_B12612_Billing_Address_Page_Canadian_Postal_Code_Validation extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*
       Scenario: Provide a Prepopulated Province Dropdown
(Reference notation #2 in attachment: billing_addresspage___update__mobile_.png)
GIVEN that I navigate to Billing Address page
WHEN the page loads
THEN change the copy for the state field to say "Province"
AND make the field a dropdown
AND prepopulate the dropdown with all the Canadian provinces

Scenario: Validate Postal Code Matches the Selected Province
(Reference notation #2 in attachment: billing_addresspage___update__mobile_.png)
GIVEN that I navigate to Billing Address page
WHEN I click the “NEXT STEP” button
THEN validate that the first digit of the postal code relates to the selected province

Scenario: Validation Error Message
(Reference notation #2 in attachment: billing_addresspage___update__mobile_.png)
GIVEN that I navigate to Billing Address page
WHEN I click the “NEXT STEP” button
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


