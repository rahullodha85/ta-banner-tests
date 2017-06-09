package com.hbcd.testscript.s5a.shopRunner.B10163_SigninLearnMore;


import com.hbcd.banner.validations.s5a.ValidateLearnMoreShopRunner;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;

public class Scen30885 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.ClickTopNavLink("Women's Apparel");
        Thread.sleep(3000);
        nav.HoverTopNav("Shop All");
        Thread.sleep(3000);
        prp.clickFirstItem();
        Thread.sleep(1000);
        ValidatePdp.hasShoprunner();
        pdp.ClickShoprunnerLearnMore();
        ValidateLearnMoreShopRunner.validateMembershipPromo();

    }
}
