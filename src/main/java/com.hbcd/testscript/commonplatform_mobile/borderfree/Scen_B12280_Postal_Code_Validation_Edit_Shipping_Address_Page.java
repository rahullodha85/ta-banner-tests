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
public class Scen_B12280_Postal_Code_Validation_Edit_Shipping_Address_Page extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*
          Scenario: Update Zip Code Field (when required)
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        (Reference attachment: Supported countries and territories_US.xls)
        GIVEN that I navigate to the shipping address edit page
        WHEN the page loads
        THEN the Zip Code copy should be replaced with “Postal Code (Required)”
        AND make the field required

        Scenario: Validation Error Message
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        GIVEN that an incorrect postal code was provided
        WHEN I click the “APPLY” button
        AND the validation fails
        THEN display the following error message per the existing Saks style guide: “Please enter a valid postal code.”

        Scenario: Update Zip Code Field (when not required)
        (Reference notation #3in attachment: International_Edit_ShippingAddress_Mobile_ToBe)
        GIVEN that I navigate to the shipping address edit page
        WHEN the page loads
        THEN the Zip Code copy should be replaced with “Postal Code”
        AND make the field optional

        Scenario: Display International Shipping Address
        (Reference notation #1 in attachment: international_shippingpage_review_displayinternati.png)
        (Reference Upstream Dependency ID: 12309)
        GIVEN that I navigate to the add/edit shipping address modal
        WHEN I choose to select an address from the "Select an Existing Address"
        THEN display any international address that has been stored to my shipping address book
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
        shp.ClickEditShippingAddress();
        ValidateShipping.hasPostelCodeRequired();

        nav.ChangeCountry("Ireland");
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        Navigate.back();
        shp.ClickEditShippingAddress();
        ValidateShipping.hasPostelCodeNotRequired();


    }
}


