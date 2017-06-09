package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B12620_Registered_Display_International_Billing_Address extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
        GIVEN that I’m on the Add/Edit Shipping Address modal
        AND I am a logged in registered user
        AND I have an international country selected in the context chooser
        WHEN I click the "Select an Existing Address" radio button
        THEN display any international address that has been stored to my billing address book
       */

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("devslot5@gmail.com","google1234");


        rsp.ClickShippingAndBillingTab();
        shp.ClickEditBillingAddress();
        shp.s5a_AddressOverlay().ClickExistingAddress();
        ValidateShippingBilling.hasInternationalAddressinShippingDropDown();
    }
}


