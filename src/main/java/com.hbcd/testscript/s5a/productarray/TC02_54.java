package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 11/7/2016.
 */
public class TC02_54 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasUserlandedOnPDPPage();
    }
}