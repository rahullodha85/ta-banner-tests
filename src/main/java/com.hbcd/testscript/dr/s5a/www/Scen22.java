package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.s5a.cc.pages.Catalog;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.BotNavLinks;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen22 extends ScenarioSaks {

    /**
     * 1. From the Bottom Nav, click 'Catalogs' than
     2. From Catalog Quick Order page, click 'Catalog Quick Order' link
     3. Enter item numbers and click 'Continue' button
     4. Select size/color for every item and click 'add to bag' button

     1. Catalog quick order page is displayed.
     2. Shop by catalog page is displayed.
     3. All items are displayed in the Catalog Quick Order page.
     4. All items should have been added to the bag.
     Note:  2 personalization items are not allowed to be added in Catalog Quick Order-tbc
     */
    @Override
    public void executeScript() throws Exception {
        nav.ClickBottomNavLink(BotNavLinks.CATALOGS);
    }
}
