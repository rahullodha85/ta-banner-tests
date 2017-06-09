package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12624_Shipping_Billing_Review_Page_Update extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
        Scenario: Display International Shipping Address
        (Reference notation #1 in attachment: International_ShippingPage_Review_ToBe.png)
        GIVEN that I have provided an international shipping address
        WHEN the page loads
        THEN display the international address that was provided

        Scenario: Display International Shipping Options
        (Reference notation #2 in attachment: International_ShippingPage_Review_ToBe.png)
        (Reference Upstream Dependencies: B-11873 (Show international shipping methods for the country on checkout))
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN display all the available international shipping options provided by Borderfree
        AND have the most recently selected shipping option selected

        Scenario: Update the Order Summary (Duties and Tax Cost)
        (Reference notation #2in attachment: International_ShippingPage_Review_ToBe.png)
        GIVEN that the shipping method has been updated on the Shipping & Billing review page
        WHEN calculating the duty and tax cost in the order summary
        THEN include the respective duty and tax cost for the updated shipping option

        Scenario: Localize Currency
        (Reference notation #3 in attachment: International_ShippingPage_Review_ToBe.png)
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN all currency displayed on the page should be localized to the respective country

        Scenario: Suppress “Make This a Gift” feature
        (Reference notation #4 in attachment: International_ShippingPage_Review_ToBe.png))
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN suppress the “Make This a Gift” link
        AND the “Gift Wrap” line item in the order summary calculation

        Scenario: Update Estimated Shipping Copy
        (Reference notation #5 in attachment: International_ShippingPage_Review_ToBe.png)
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN update the “Estimated shipping & Handling:” copy to say “Estimated Shipping:”

        Scenario: Suppress the Shipping Method Edit Button (Located in the Order Summary)
        GIVEN that I navigate to the Shipping & Billing review page
        WHEN the page loads
        THEN suppress the “Edit” button that is located in the order summary section of the page
       */

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");

        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);

        rsp.ClickShippingAndBillingTab();

        ValidateShippingBilling.hasInternationalShippingAddress();

        //**********

        ValidateShippingBilling.hasShippingMethods("international");

        //**********
        ValidateShippingBilling.hasLocalCurrency("INR");
        //***********
        ValidateShippingBilling.hasNoMakeGiftAndGiftWrap();
        //**************
        ValidateShippingBilling.hasEditShippingMethodButtonRemoved();
        //*************
        ValidateShippingBilling.hasEstimatedShippingLabel();
        //************
        Storage.save("currentDutiesTaxPrice", Find.Object("rsTaxPriceLbl").getText().value());
        //implement this method
        shp.SelectShippingMethodInternational("express_paid");

        ValidateShippingBilling.hasDutiesAndTaxUpdated(Storage.get("currentDutiesTaxPrice").toString());

    }
}


