package com.hbcd.testscript.commonplatform.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;
import com.hbcd.utility.dao.impl.MongoProductImpl;

import java.util.HashMap;
import java.util.Map;

public class Scen03 extends ScenarioCommonPlatform {
    //minibag

    @Override
    public void executeScript() throws Exception {
        String regularItem = itemData.get(ItemType.REGULAR);

        Map itemDetails = MongoProductImpl.getDetails(regularItem);
        String expectedBrandName = (String)itemDetails.get("brand_name");

        nav.SearchFor(regularItem);
        pdp.AddToBag();

        Thread.sleep(1500);
        ValidateAemPdp.hasBrandNameMini(expectedBrandName);
        ValidateAemPdp.hasQtyMini("1");
        ValidateAemPdp.hasColorMini("color");
        ValidateAemPdp.hasSizeMini();
        //fix later
        //ValidateAemPdp.hasPriceMini();
        ValidateAemPdp.hasItemInStock("in stock");
    }
}