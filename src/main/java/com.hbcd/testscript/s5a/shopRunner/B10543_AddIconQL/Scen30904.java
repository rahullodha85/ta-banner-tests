package com.hbcd.testscript.s5a.shopRunner.B10543_AddIconQL;


import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.overlays.QuickLookOverLayBase;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.HomePage;


public class Scen30904 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        nav.SearchFor((dataObject.getSkuListInfo().get(1)));
        pdp.AddToBag();
        Thread.sleep(3000);
        HomePage.Go();
        //pdp.AddToBag(2);
        //pdp.EnterBag();
    }

}
