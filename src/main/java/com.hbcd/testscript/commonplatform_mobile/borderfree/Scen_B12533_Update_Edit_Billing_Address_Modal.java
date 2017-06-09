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
public class Scen_B12533_Update_Edit_Billing_Address_Modal extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*

      Scenario: Display International Billing Address
(Reference notation #1 in attachment: international_billingpage_review_displayinternatio.png)
(Reference Upstream Dependencies ID: B-12531)
GIVEN that I navigate to the add/edit billing address page
AND I have an international country selected in the context chooser
WHEN the page loads
THEN display any international address that has been stored to my billing address book

Scenario: Update the “State” field
(Reference notation #1 in attachment: international_add_billingaddress_mobile_tobe.png)
GIVEN that I navigate to the edit billing address page
WHEN the page loads
THEN change the copy of the State field to say “Region/Province”
AND make this an optional text field

Scenario: Update Zip Code Copy
(Reference notation #2 in attachment: international_add_billingaddress_mobile_tobe.png)
GIVEN that I navigate to the edit billing address page
WHEN the page loads
THEN change the copy on the Zip Code field to say “Postal Code (Required)”

Scenario: Remove Intl. State/Province/Region Copy
(Reference notation #3 in attachment: international_add_billingaddress_mobile_tobe.png)
GIVEN that I navigate to the edit billing address page
WHEN the page loads
THEN do not display this field (Note: to be replaced by "Region/Province" in Scenario: Update the "State" field)

Scenario: Prepopulate “Country” Field
(Reference notation #4 in attachment: international_add_billingaddress_mobile_tobe.png)
GIVEN that I navigate to the edit shipping address page
WHEN the page loads
THEN prepopulate the Country selector with all Borderfree countries available for billing

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


