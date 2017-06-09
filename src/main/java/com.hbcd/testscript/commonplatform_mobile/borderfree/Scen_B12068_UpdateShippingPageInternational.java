package com.hbcd.testscript.commonplatform_mobile.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
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
public class Scen_B12068_UpdateShippingPageInternational extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


        /*
               Scenario: Update the “State” field
        (Reference notation #1 in attachment: International_ShippingPage_Mobile_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN change the copy of the State field to say “Region/Province”
        AND make this an optional text field

        Scenario: Display International Shipping Options
        (Reference notation #2 in attachment: International_ShippingPage_Mobile_ToBe.png)
        (Reference Upstream Dependencies: B-11873 (Show international shipping methods for the country on checkout))
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN display the available international shipping options provided by Borderfree
        AND have the “Standard” shipping method (determined by Borderfree) preselected

        Scenario: Add “Country” Field
        (Reference notation #3 in attachment: International_ShippingPage_Mobile_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN display in a disabled text box the shipping country destination

        Scenario: Updating the Context Chooser (Shipping or Currency)
        GIVEN that I’m on the international shipping page
        WHEN I change the shipping or currency attributes in the Borderfree Context Chooser
        THEN navigate me back to the O5th Bag
        AND validated that my selected items are shippable to the selected country
        AND update any currency attributes with the respective currency selected
        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");


        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");

        ValidateShipping.hasRegionProvinceText("");

        //***********
        ValidateShipping.isCountryDisabled();

        //***********
        ValidateShipping.hasStandardShippingSelected();
        ValidateShipping.hasShippingMethods();


        //***********
        nav.ChangeCountry("United Kingdom");
        ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");
        //implement
        ValidateBag.isOnSaksBagPage();
        ValidateBag.areItemsShippable();
        ValidateBag.hasCurrency("GBP");



    }
}


