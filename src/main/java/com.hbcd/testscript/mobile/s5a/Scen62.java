package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * For O5M Scripts, Validate Product Brand Name, SKU ID, Size and Color in PDP Page
 */
public class Scen62 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor("0400087587687");
        ValidatePdp.hasItemNumber("0400087587687");
        ValidatePdp.hasBrandName("Adrianna Papell");
        ValidatePdp.hasSPD("Embroidered Lace Dress");
        ValidatePdp.hasColorSwatches();
    }
}
