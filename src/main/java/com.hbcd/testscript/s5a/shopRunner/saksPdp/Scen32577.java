package com.hbcd.testscript.s5a.shopRunner.saksPdp;


import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32577 extends ScenarioChkout{

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasShoprunner();
        Thread.sleep(3000);
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(5000);
        ValidatePdp.validateSignoutShopRunner();






    }

}