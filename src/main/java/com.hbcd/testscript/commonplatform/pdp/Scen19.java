package com.hbcd.testscript.commonplatform.pdp;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by aalfaruk on 5/20/2016.
 */
public class Scen19 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        //0400089776829
        nav.SearchFor("0493429107113");
        ValidatePdp.hasDropDownAvaliableOnPDP();

    }
}
