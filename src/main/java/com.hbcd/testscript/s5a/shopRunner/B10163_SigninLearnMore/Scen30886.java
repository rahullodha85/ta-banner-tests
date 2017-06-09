package com.hbcd.testscript.s5a.shopRunner.B10163_SigninLearnMore;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen30886 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        nav.ClickSubNavLeft("WHAT'S NEW");
        prp.clickFirstItem();
        ValidatePdp.hasNoShoprunner();


    }
}
