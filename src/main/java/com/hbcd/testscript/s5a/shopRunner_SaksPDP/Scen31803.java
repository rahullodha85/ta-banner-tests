package com.hbcd.testscript.s5a.shopRunner_SaksPDP;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen31803 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        SearchFunction.SearchFor(dataObject.getSkuListInfo().get(0));
        Thread.sleep(3000);
        ValidatePdp.hasNoShoprunner();
        Thread.sleep(3000);

    }


}
