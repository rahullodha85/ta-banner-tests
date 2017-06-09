package com.hbcd.testscript.mobile.s5a.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen07 extends ScenarioCommonPlatform {
    //final sale item
    //During the sales event, items that cannot be returned are marked as Final Sale
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("item1").value());
        pdp.ClickShippingAndReturns();

        ValidateAemPdp.isFinalSaleItem();
    }
}