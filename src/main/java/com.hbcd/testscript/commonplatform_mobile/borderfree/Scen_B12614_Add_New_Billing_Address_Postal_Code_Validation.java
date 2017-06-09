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
public class Scen_B12614_Add_New_Billing_Address_Postal_Code_Validation extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*
       Scenario: Update Zip Code Field (when required)
(Reference notation #2 in attachment: international_add_billingaddress_mobile_tobe.png)
 (Reference attachment: Supported countries and territories_US.xls)
GIVEN that I navigate to the international New Billing Address page
WHEN the page loads
AND the zip code is deemed required per the spreadsheet provided by Borderfree
THEN the Zip Code copy should be replaced with “Postal Code (Required)”
AND make the field required

Scenario: Validation Error Message
(Reference notation #2 in attachment: international_add_billingaddress_mobile_tobe.png)
 (Email_Re International Checkout Service.pdf)
GIVEN that an incorrect postal code was provided
WHEN I click the “APPLY” button
AND the validation fails
THEN display the following error message per the existing Saks style guide: “Please enter a valid postal code.”

Scenario: Update Zip Code Field (when not required)
(Reference notation #2 in attachment: international_add_billingaddress_mobile_tobe.png)
 (Reference attachment: Supported countries and territories_US.xls)
GIVEN that I navigate to the international New Billing Address page
WHEN the page loads
AND the zip code is deemed NOT required per the spreadsheet provided by Borderfree
THEN the Zip Code copy should be replaced with “Postal Code”
AND the field made optional
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


