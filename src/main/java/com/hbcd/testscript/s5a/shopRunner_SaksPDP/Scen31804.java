package com.hbcd.testscript.s5a.shopRunner_SaksPDP;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen31804 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
    //search for chanel item and it will not show the shoprunner icon
        SearchFunction.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasNoShoprunner();
        Thread.sleep(3000);


    }
}
