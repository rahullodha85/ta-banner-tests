package com.hbcd.testscript.s5a.PDP;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;
import com.hbcd.utility.dao.impl.MongoProductImpl;

import java.util.Map;

public class Scen03 extends ScenarioCommonPlatform {
    //minibag

    @Override
    public void executeScript() throws Exception {
        String regularItem = itemData.get(ItemType.REGULAR);

        Map details = MongoProductImpl.getDetails(regularItem);
        String expectedBrand = (String)details.get("brand_name");

        nav.SearchFor(regularItem);
        pdp.AddToBag();
        ValidateAemPdp.hasBrandNameMini(expectedBrand);
        ValidateAemPdp.hasQtyMini("qty");
        ValidateAemPdp.hasColorMini("color");
        ValidateAemPdp.hasSizeMini();
        //fix later
        //ValidateAemPdp.hasPriceMini();
        ValidateAemPdp.hasItemInStock("in stock");
    }
}