package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;

public class Scen63 extends ScenarioSaks{

    /*

   "1.Click the search icon from the Top Navigation

(Root Seach)"	1. Product array page is displayed and all categories from Shop by Category and Sale are displayed on the left hand navigation.


     */
    @Override
    public void executeScript() throws Exception {
        SearchFunction.ClickSearch() ;
        ValidatePrp.hasShopByCategory();
        ValidatePrp.hasSaleCategory();
    }
}

