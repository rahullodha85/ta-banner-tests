package com.hbcd.testscript.s5a.shopRunner.saksPdp;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32580 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
    //search for chanel item and it will not show the shoprunner icon
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasNoShoprunner();
        pdp.selectSizeSwatch("1.7 OZ.");
        pdp.AddToBag(2);
        Thread.sleep(3000);


    }
}
