package com.hbcd.testscript.s5a.PDP;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen07 extends ScenarioCommonPlatform {
    //final sale item
    //During the sales event, items that cannot be returned are marked as Final Sale
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("finalSale").value());
        pdp.ClickShippingAndReturns();

        ValidateAemPdp.isFinalSaleItem();
    }
}