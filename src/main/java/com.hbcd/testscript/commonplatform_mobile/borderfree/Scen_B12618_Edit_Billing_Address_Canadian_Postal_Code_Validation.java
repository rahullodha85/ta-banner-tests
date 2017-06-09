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
public class Scen_B12618_Edit_Billing_Address_Canadian_Postal_Code_Validation extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*Scenario: Provide a Prepopulated Province Dropdown
(Reference notation #2 in attachment: international_edit_billingaddress_mobile_tobe.png)
GIVEN that I navigate to Edit Billing Address page
WHEN the page loads
THEN change the copy for the state field to say "Province"
AND make the field a dropdown
AND prepopulate the dropdown with all the Canadian provinces

Scenario: Validate Postal Code Matches the Selected Province
(Reference notation #2 in attachment: international_edit_billingaddress_mobile_tobe.png)
GIVEN that I navigate to Edit Billing Address page
WHEN I click the “APPLY” button
THEN validate that the first digit of the postal code relates to the selected province

Scenario: Validation Error Message
(Reference notation #2 in attachment: international_edit_billingaddress_mobile_tobe.png)
GIVEN that I navigate to Edit Billing Address page
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
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        Navigate.back();
        shp.ClickEditBillingAddress();
        shp.ClickEditEditBillingAddress();

        ValidateShipping.hasBillingCanadaProvinceList();
        ValidateShipping.hasBillingRegionProvinceText("canada");
        shp.EditBillingZipCode("12200");
        ValidateShipping.hasBillPostalCodeProvinceMismatch();
        shp.EditBillingZipCode("correct-zipCode");
        ValidateShipping.hasBillingPostalCodeProvinceMatch();



    }
}


