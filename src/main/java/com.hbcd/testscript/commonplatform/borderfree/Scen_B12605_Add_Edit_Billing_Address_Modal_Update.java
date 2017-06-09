package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12605_Add_Edit_Billing_Address_Modal_Update extends ScenarioChkout {
    public void executeScript() throws Exception {


       /*
        Scenario: Update the “State” field
(Reference notation #1 in attachment: international_addedit_billingaddress_modal_desktop.png)
GIVEN that I navigate to the add/edit billing address modal
WHEN the modal loads
THEN change the copy of the State field to say “Region/Province”
AND make this an optional text field

Scenario: Update Zip Code Copy
(Reference notation #2 in attachment: international_addedit_billingaddress_modal_desktop.png)
GIVEN that I navigate to the add/edit billing address modal
WHEN the modal loads
THEN change the copy on the Zip Code field to say “Postal Code (Required)”

Scenario: Remove Intl. State/Province/Region Copy
(Reference notation #3 in attachment: international_addedit_billingaddress_modal_desktop.png)
GIVEN that I navigate to the add/edit billing address modal
WHEN the modal loads
THEN do not display this field (Note: to be replaced by "Region/Province" in Scenario: Update the "State" field)

Scenario: Prepopulate “Country” Field
(Reference notation #4 in attachment: international_addedit_billingaddress_modal_desktop.png)
GIVEN that I navigate to the add/edit billing address modal
WHEN the modal loads
        */

        nav.ChangeCountry("United Kingdom");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");
        shp.AddBillingAddress(dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),true);
        rsp.ClickShippingAndBillingTab();
        shp.ClickEditBillingAddress();
        ValidateShippingBilling.hasCountryDropDown();
        ValidateShippingBilling.hasZipCodeRequireText();
        ValidateShippingBilling.hasRegionProvinceField("India");
        shp.s5a_AddressOverlay().ClickEnterNewAddress();
        ValidateShippingBilling.hasRegionProvinceField("India");
        ValidateShippingBilling.hasZipCodeRequireText();
        ValidateShippingBilling.hasCountryDropDown();
        //********************

        //add make optional text field for state

    }
}


