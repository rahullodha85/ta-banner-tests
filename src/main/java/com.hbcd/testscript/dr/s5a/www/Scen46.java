package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateLogin;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.validations.s5a.ValidateStoreLocationEvents;
import com.hbcd.base.ScenarioSaks;

public class Scen46 extends ScenarioSaks {
    /*
   "Verify Login Layer

   Add items to the Saks Bag and proceed to guest checkout."	User should not see email requrement on the sign-up overlay guest checkout and can proceed to checkout without entering email address
    */

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0400088664660");
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");

        ValidateShippingBilling.hasPageLanded();
    }
}

