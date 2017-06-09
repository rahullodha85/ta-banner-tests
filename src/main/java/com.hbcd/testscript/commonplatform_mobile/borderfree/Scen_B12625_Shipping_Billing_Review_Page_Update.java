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
public class Scen_B12625_Shipping_Billing_Review_Page_Update extends ScenarioMobileSaks {
    public void executeScript() throws Exception {

       /*
       Scenario: Display International Shipping Address
        (Reference notation #1 in attachment: International_ShippingPage_Review_Mobile_ToBe.png)
        GIVEN that I have provided an international shipping address
        WHEN the page loads
        THEN display the international address that was provided

        Scenario: Display International Shipping Options
        (Reference notation #2 in attachment: International_ShippingPage_Review_Mobile_ToBe.png)
        (Reference Upstream Dependencies: B-11873 (Show international shipping methods for the country on checkout))
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN display all the available international shipping options provided by Borderfree
        AND have the most recently selected shipping option selected
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


