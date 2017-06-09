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
public class Scen_B12276_Update_the_Add_Shipping_Address_Page extends ScenarioMobileSaks {
    public void executeScript() throws Exception {


       /*
        Scenario: Add “Country” Field
        (Reference notation #1 in attachment: International_Add_ShippingAddress_Mobile_ToBe.png)
        GIVEN that I navigate to the new shipping address page
        WHEN the page displays
        THEN display in a disabled text box the shipping country chosen in the Context Chooser

        Scenario: Update the “State” field
        (Reference notation #2 in attachment: International_ Add_ShippingAddress_Mobile_ToBe.png)
        GIVEN that I navigate to the new shipping address page
        WHEN the page displays
        THEN change the copy of the State field to say “Region/Province”
        AND make this an optional text field

        Scenario: Update Zip Code Copy
        (Reference notation #3in attachment: International_Add_ShippingAddress_Mobile_ToBe.png)
        GIVEN that I navigate to the new shipping address page
        WHEN the page displays
        THEN change the copy of the Zip Code field to say “Postal Code (Required)”

        */

        // nav.ChangeCountry("United Kingdom");
        // ValidateHome.hasCountryChanged("www.saksfifthavenue.com/static/images/flags/GB.gif");


        nav.SearchFor("");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("user@s5a.com");
        shp.SelectShippingMethodInternational("DHL Express");
        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getCity(), dataObject.getState(), "", true);
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        //fill it
        rsp.SelectShippingMethodInternational("standard");
        //Need core level implementation
        //Navigate.back();
        //fill it
        ValidateShippingBilling.hasShippingMethodUpdated("standard");


        //***********
        /*
                GIVEN that I have selected a shipping method on the shipping page
        WHEN the shipping method is displayed anywhere in the downstream UI (Payment and Review & Submit page)
        THEN display the most recently selected shipping method
         */


    }
}


