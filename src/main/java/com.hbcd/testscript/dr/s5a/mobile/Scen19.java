package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioMobileSaks{
    /*
    Search for Item # with space at the end for item that has reviews and press <ENTER>

    User should be taken to the item's PA and its star ratings and reviews count should display
     */
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor("0427915085753 ");


    }
}
