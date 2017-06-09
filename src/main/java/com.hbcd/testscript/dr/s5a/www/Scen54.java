package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by ephung on 1/6/2016.
 */
public class Scen54 extends ScenarioChkout {
    public void executeScript() throws Exception {
        String item1 = itemData.get(ItemType.REGULAR);
        String item2 = itemData.get(ItemType.REGULAR);

        nav.SearchFor(item1);
        pdp.AddToBag(1);
        nav.SearchFor(item2);  //Pre Order Item (Inventory is 0)
        pdp.AddToBag(1);
        pdp.EnterBag();
        //Validate "In Stock"
        //Validate Pre-Order with "Latest Expected Ship date dd/mm/yyyy Item may ship sooner than this date"
    }
}
