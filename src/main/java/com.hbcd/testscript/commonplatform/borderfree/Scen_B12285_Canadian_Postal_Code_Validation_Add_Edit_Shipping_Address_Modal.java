package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12285_Canadian_Postal_Code_Validation_Add_Edit_Shipping_Address_Modal extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
         Scenario: Provide a Prepopulated Province Dropdown
        (Reference notation #3 in attachment: International_ShippingPage_Review_EditAddress_ToBe.png)
        GIVEN that I navigate to the Add/Edit Shipping Address modal
        WHEN  the modal loads
        THEN change the copy for the state field to say "Province"
        AND make the field a dropdown
        AND prepopulate the dropdown with all the Canadian provinces

        Scenario: Validate Postal Code Matches the Selected Province
        (Reference notation #3 in attachment: International_ShippingPage_Review_EditAddress_ToBe.png)
        GIVEN that I navigate to the Add/Edit Shipping Address modal
        WHEN I click the “APPLY” button
        THEN validate that the first digit of the postal code relates to the selected province

        Scenario: Validation Error Message
        (Reference notation #3 in attachment: International_ShippingPage_Review_EditAddress_ToBe.png)
        GIVEN that I navigate to the Add/Edit Shipping Address modal
        WHEN I click the “APPLY” button
        AND the validation fails
        THEN display the following error message per the existing Saks style guide: “Province and postal code do not match.”

         **/

       /* nav.ChangeCountry("canada");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");*/




        Navigate.go(ConfigurationLoader.getWebSiteURL()+"main/context_chooser.jsp?bmForm=context_chooser&bmFormID=l7FwH4x&bmUID=l7FwH4y&bmIsForm=true&bmPrevTemplate=%2Fmain%2Fcontext_chooser.jsp&bmSingle=INTERNATIONAL%3C%3Ecurrency&INTERNATIONAL%3C%3Ecurrency=CAD&bmDynamic=INTERNATIONAL%3C%3Ecurrency%3AARS%3AAUD%3ABHD%3APAB%3ABBD%3ABZD%3ABOB%3AGBP%3ABGN%3ACAD%3AKYD%3ACLP%3ACOP%3ANIO%3ACRC%3ACZK%3ADKK%3ADOP%3AEGP%3AEUR%3APYG%3AHKD%3AHUF%3AINR%3AIDR%3AILS%3AJMD%3AJPY%3AJOD%3AKRW%3AKWD%3AHNL%3AMXN%3ARON%3ANZD%3ANOK%3AOMR%3APKR%3APEN%3APHP%3APLN%3AQAR%3AGTQ%3AKHR%3AMVR%3ASAR%3ASGD%3AZAR%3ALKR%3ASEK%3ACHF%3ATWD%3ABDT%3ATHB%3ATRY%3AUSD%3AAED%3ACNY%3A&bmSingle=USA&USA=US+Dollar+%28USD%29&bmSingle=INTERNATIONAL%3C%3Ecountry&INTERNATIONAL%3C%3Ecountry=CA&bmDynamic=INTERNATIONAL%3C%3Ecountry%3AAG%3AAW%3AAU%3AAT%3ABH%3ABD%3ABB%3ABE%3ABZ%3ABM%3ABO%3ABR%3ABN%3ABG%3AKH%3ACA%3AKY%3ACL%3ACN%3ACO%3ACR%3AHR%3ACY%3ACZ%3ADK%3ADM%3ADO%3AEC%3AEG%3ASV%3AEE%3AFI%3AFR%3AGF%3ADE%3AGI%3AGR%3AGD%3AGP%3AGT%3AGG%3AHN%3AHK%3AHU%3AIS%3AIN%3AID%3AIE%3AIL%3AIT%3AJM%3AJP%3AJE%3AJO%3AKR%3AKW%3ALV%3ALI%3ALT%3ALU%3AMO%3AMV%3AMT%3AMQ%3AMX%3AMC%3AMS%3ANL%3ANZ%3ANI%3ANO%3AOM%3APK%3APA%3APY%3APE%3APH%3APL%3APT%3AQA%3ARO%3ARU%3ARE%3AKN%3ALC%3ASA%3ASG%3ASK%3ASI%3AZA%3AES%3ALK%3ASE%3ACH%3ATW%3ATH%3ATT%3ATR%3ATC%3AUS%3AAE%3AGB%3A&bmSubmit=update&update=Save+%26+Continue+Shopping&bmSubmit=proceed&bmSingle=USA&USA=US+Dollar+%28USD%29");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/checkout.jsp?itemQuantity=1&sku_id=1689949379014814&productCode=0413806435288&bmForm=add_saks_suggests_item_service_product_array");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp?bmUID=l6TY3P9");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp#login");
        Navigate.go(ConfigurationLoader.getWebSiteURL()+"checkout/SaksBag.jsp#login");
        bag.LoginOverlay().LoginWith("abcd@yahoo.com");

        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);

        rsp.ClickShippingAndBillingTab();
        shp.ClickEditShippingAddress();
        ValidateShippingBilling.hasRegionProvinceField("canada");
        ValidateShippingBilling.hasCanadaProvinceList();
        shp.s5a_AddressOverlay().ClickEnterNewAddress();
        ValidateShippingBilling.hasRegionProvinceField("canada");
        ValidateShippingBilling.hasCanadaProvinceList();
        shp.s5a_AddressOverlay().ClickCancel();
        //*********************
        SearchFunction.ClearSearchBox();
        shp.ClickEditShippingAddress();

        shp.s5a_AddressOverlay().editZipCode("110002");
 //       shp.s5a_AddressOverlay().ClickApply();
        ValidateShippingBilling.hasNotMatchingZipCodeAndProvince();
        ValidateShippingBilling.hasPageLanded();
        //shp.s5a_AddressOverlay().ClickEnterNewAddress();
        ValidateShippingBilling.hasPageLanded();
        shp.s5a_AddressOverlay().fillNewShippingAddress(dataObject.getAddress1(), dataObject.getCity(),dataObject.getState(), "110002");
       // shp.s5a_AddressOverlay().ClickApply();
        ValidateShippingBilling.hasNotMatchingZipCodeAndProvince();
        shp.s5a_AddressOverlay().ClickCancel();

        //*********************
        SearchFunction.ClearSearchBox();
        shp.ClickEditShippingAddress();

        shp.s5a_AddressOverlay().editZipCode(dataObject.getZipCode());
        //shp.s5a_AddressOverlay().ClickApply();
        ValidateShippingBilling.hasMatchingZipCodeAndProvince();

       // shp.s5a_AddressOverlay().ClickEnterNewAddress();
        shp.s5a_AddressOverlay().fillNewShippingAddress(dataObject.getAddress1(), dataObject.getCity(),dataObject.getState(), dataObject.getZipCode());
        //shp.s5a_AddressOverlay().ClickApply();
        ValidateShippingBilling.hasMatchingZipCodeAndProvince();


    }
}


