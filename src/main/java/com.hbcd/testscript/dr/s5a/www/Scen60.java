package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen60 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0419024843133");
        ValidatePdp.hasShoprunner();
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("drScen23@saks.com", "test123");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");

    }
}
