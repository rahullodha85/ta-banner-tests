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
public class Scen_B12148_Postal_Code_Validation extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


       /*
         Scenario: Update Zip Code Field (when required for the selected country)
        (Reference notation #4in attachment: International_ShippingPage_mobile_ToBe.jpg)
        (Reference attachment: Supported countries and territories_US.xls)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN the Zip Code copy should be replaced with “Postal Code (Required)”
        AND make the field required

        Scenario: Validation Error Message
        (Reference notation #4in attachment: International_ShippingPage_mobile_ToBe.jpg)
        Reference Email_Re International Checkout Service.pdf)
        GIVEN that an incorrect postal code was provided
        WHEN I click the “CONTINUE CHECKOUT” button
        AND the validation fails
        THEN display the following error message per the existing Saks style guide: “Please enter a valid postal code.”

        Scenario: Update Zip Code Field (when not required for the selected country)
        (Reference notation #4in attachment: International_ShippingPage_mobile_ToBe.jpg)
        (Reference attachment: Supported countries and territories_US.xls)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN the Zip Code copy should be replaced with “Postal Code”
        AND make the field optional
        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");


        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();

        ValidateShipping.hasPostelCodeRequired();

        //***********
        nav.ChangeCountry("Ireland");
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        ValidateShipping.hasPostelCodeNotRequired();

        //Final Scenario is not valid

       // shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getCity(), dataObject.getState(), "", true);
       // ValidateShipping.hasEnterPostalCodeMessage();





    }
}


