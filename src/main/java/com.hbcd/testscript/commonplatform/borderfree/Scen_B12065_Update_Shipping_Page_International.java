package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12065_Update_Shipping_Page_International extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*

        Scenario: Localize Currency
        (Reference notation #1 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN all currency displayed on the page should be localized to the respective country

        Scenario: Suppress “Make This a Gift” feature
        (Reference notation #2 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN suppress the “Make This a Gift” link
        AND the “Gift Wrap” line item in the order summary calculation

        Scenario: Update the “State” field
        (Reference notation #3 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN change the copy of the State field to say “Region/Province”
        AND make this an optional text field

        Scenario: Display International Shipping Options
        (Reference notation #4 in attachment: International_ShippingPage_ToBe.png)
        (Reference Upstream Dependencies: B-11873 (Show international shipping methods for the country on checkout))
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN display the available international shipping options provided by Borderfree
        AND have the “Standard” shipping method (determined by Borderfree) preselected

        Scenario: Update the Order Summary (Duties and Tax Cost)
        (Reference notation #5 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that a shipping method has been selected on the international shipping page
        WHEN calculating the duty and tax cost in the order summary
        THEN include the respective duty and tax cost provided by Borderfree

        Scenario: Suppress the “Signature Required at Delivery” checkbox
        (Reference notation #6 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN suppress the “Signature Required at Delivery” checkbox

        Scenario: Update Estimated Shipping Copy
        (Reference notation #7 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN update the “Estimated shipping & Handling:” copy to say “Estimated Shipping:”

        Scenario: Update the Order Summary (Estimated Shipping)
        (Reference notation #7 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that a shipping method has been selected on the international shipping page
        WHEN calculating the estimated shipping cost in the order summary
        THEN include the respective shipping cost provided by Borderfree

        Scenario: Suppress Multi-ship Selector
        (Reference notation #8 in attachment: International_ShippingPage_ToBe.png))
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN suppress the multi-ship checkbox

        Scenario: Add “Country” Field
        (Reference notation #9 in attachment: International_ShippingPage_ToBe.png)
        GIVEN that I navigate to the international shipping page
        WHEN the page loads
        THEN display (in a disabled text box) the shipping country destination

        Scenario: Updating the Context Chooser (Shipping or Currency)
        GIVEN that I’m on the international shipping page
        WHEN I change the shipping or currency attributes in the Borderfree Context Chooser
        THEN navigate me back to the O5th Bag
        AND validate that my selected items are still shippable to the selected country
        AND update any currency attributes with the respective currency selected

        */

       /* nav.ChangeCountry("United Kingdom");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(2);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");
        */



       /* Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp?bmForm=continue_to_checkout_service");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp?bmForm=get_option_list_service&listName=titles");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp?bmForm=get_option_list_service&listName=states");

        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp#init1");*/
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"main/context_chooser.jsp?bmForm=context_chooser&bmFormID=l7FwH4x&bmUID=l7FwH4y&bmIsForm=true&bmPrevTemplate=%2Fmain%2Fcontext_chooser.jsp&bmSingle=INTERNATIONAL%3C%3Ecurrency&INTERNATIONAL%3C%3Ecurrency=GBP&bmDynamic=INTERNATIONAL%3C%3Ecurrency%3AARS%3AAUD%3ABHD%3APAB%3ABBD%3ABZD%3ABOB%3AGBP%3ABGN%3ACAD%3AKYD%3ACLP%3ACOP%3ANIO%3ACRC%3ACZK%3ADKK%3ADOP%3AEGP%3AEUR%3APYG%3AHKD%3AHUF%3AINR%3AIDR%3AILS%3AJMD%3AJPY%3AJOD%3AKRW%3AKWD%3AHNL%3AMXN%3ARON%3ANZD%3ANOK%3AOMR%3APKR%3APEN%3APHP%3APLN%3AQAR%3AGTQ%3AKHR%3AMVR%3ASAR%3ASGD%3AZAR%3ALKR%3ASEK%3ACHF%3ATWD%3ABDT%3ATHB%3ATRY%3AUSD%3AAED%3ACNY%3A&bmSingle=USA&USA=US+Dollar+%28USD%29&bmSingle=INTERNATIONAL%3C%3Ecountry&INTERNATIONAL%3C%3Ecountry=GB&bmDynamic=INTERNATIONAL%3C%3Ecountry%3AAG%3AAW%3AAU%3AAT%3ABH%3ABD%3ABB%3ABE%3ABZ%3ABM%3ABO%3ABR%3ABN%3ABG%3AKH%3ACA%3AKY%3ACL%3ACN%3ACO%3ACR%3AHR%3ACY%3ACZ%3ADK%3ADM%3ADO%3AEC%3AEG%3ASV%3AEE%3AFI%3AFR%3AGF%3ADE%3AGI%3AGR%3AGD%3AGP%3AGT%3AGG%3AHN%3AHK%3AHU%3AIS%3AIN%3AID%3AIE%3AIL%3AIT%3AJM%3AJP%3AJE%3AJO%3AKR%3AKW%3ALV%3ALI%3ALT%3ALU%3AMO%3AMV%3AMT%3AMQ%3AMX%3AMC%3AMS%3ANL%3ANZ%3ANI%3ANO%3AOM%3APK%3APA%3APY%3APE%3APH%3APL%3APT%3AQA%3ARO%3ARU%3ARE%3AKN%3ALC%3ASA%3ASG%3ASK%3ASI%3AZA%3AES%3ALK%3ASE%3ACH%3ATW%3ATH%3ATT%3ATR%3ATC%3AUS%3AAE%3AGB%3A&bmSubmit=update&update=Save+%26+Continue+Shopping&bmSubmit=proceed&bmSingle=USA&USA=US+Dollar+%28USD%29");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp?itemQuantity=3&sku_id=1689949379014814&productCode=0413806435288&bmForm=add_saks_suggests_item_service_product_array");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp?bmUID=l6TY3P9");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp#login");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp#login");
        bag.LoginOverlay().LoginWith("abcd@yahoo.com");
        //implement this method
        ValidateShippingBilling.isCountryDisabled();

        //***********
        ValidateShippingBilling.isStandardPreselected();
        ValidateShippingBilling.hasShippingMethods("international");
        //***********
        ValidateShippingBilling.hasLocalCurrency("GBP");
        //***********
        ValidateShippingBilling.hasEstimatedShippingLabel();

        //***********
        ValidateShippingBilling.hasDutiesAndTaxFromBorderFree(Double.parseDouble(Find.Object("rsTaxPriceLbl").getText().value().split("£")[1]));
        //***********

       // ValidateShippingBilling.hasShippingPriceUpdated(Storage.get("currentShippingPrice").toString());
        //***********
        ValidateShippingBilling.isSignitureDeliveryNotPresent();
        //***********
        ValidateShippingBilling.hasNoMakeGiftAndGiftWrap();
        //***********
        ValidateShippingBilling.hasNoMultiShippingMessage();
        //***********
        ValidateShippingBilling.hasRegionProvinceField("India");

        //****************
       // ValidateShippingBilling.hasPageLanded();
        Storage.save("currentShippingPrice", BrowserAction.javascriptExecuteScript("return Order.getSummary().shippingCost"));
        //implement this method
        shp.SelectShippingMethodInternational("express_unpaid");
        ValidateShippingBilling.hasPageLanded();

        ValidateShippingBilling.hasShippingPriceUpdated(Storage.get("currentShippingPrice").toString());
        //****************************
        ValidateShippingBilling.hasPageLanded();
        nav.ChangeCountry("India");

        //navigate to bag page
        //validate items are shippable to the country
        //currency updated
        ValidateBag.isBagPage();
        ValidateBag.isItemShippable();
        ValidateBag.hasCurrency("INR");
    }
}


