package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12608_Add_Edit_Billing_Address_Modal_Canadian_Postal_Code extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
      Scenario: Provide a Prepopulated Province Dropdown


    GIVEN that I navigate to the Add/Edit Billing Address modal
    WHEN the modal loads
    THEN change the copy for the state field to say "Province"
    AND make the field a dropdown
    AND prepopulate the dropdown with all the Canadian provinces

    Scenario: Validate Postal Code Matches the Selected Province


    GIVEN that I navigate to the Add/Edit Billing Address modal
    WHEN I click the “APPLY” button
    THEN validate that the first digit of the postal code relates to the selected province

    Scenario: Validation Error Message


    GIVEN that I navigate to the Add/Edit Billing Address modal
    WHEN I click the “APPLY” button
    AND the validation fails
    THEN display the following error message per the existing Saks style guide: “Province and postal code do not match.”

*/

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        shp.ClickCheckoutOptionalAddressConfirmation();
        rsp.ClickShippingAndBillingTab();
        shp.ClickEditBillingAddress();
        ValidateShippingBilling.hasRegionProvinceField("canada");
        ValidateShippingBilling.hasDropDownProvinces(15);

        //*************************
        shp.s5a_AddressOverlay().fillNewBillingAddress("address","city","state","incorrect-zipcode");
        ValidateShippingBilling.hasNotMatchingZipCodeAndProvince();

        //*************************
        shp.s5a_AddressOverlay().fillNewBillingAddress("address","city","state","zipcode");
        ValidateShippingBilling.hasMatchingZipCodeAndProvince();


        //modified overlay
        shp.s5a_AddressOverlay().ClickEnterNewAddress();


        ValidateShippingBilling.hasRegionProvinceField("canada");
        ValidateShippingBilling.hasDropDownProvinces(15);


        //*************************
        shp.s5a_AddressOverlay().fillNewBillingAddress("address","city","state","incorrect-zipcode");
        ValidateShippingBilling.hasNotMatchingZipCodeAndProvince();

        //*************************
        shp.s5a_AddressOverlay().fillNewBillingAddress("address","city","state","zipcode");
        ValidateShippingBilling.hasMatchingZipCodeAndProvince();



    }
}


