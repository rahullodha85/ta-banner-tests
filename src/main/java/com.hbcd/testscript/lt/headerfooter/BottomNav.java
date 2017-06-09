package com.hbcd.testscript.lt.headerfooter;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.BotNavLinks;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by vevinmoza on 10/7/16.
 */
public class BottomNav extends ScenarioChkout {
    //Saks Nightly: Included

    public void executeScript() throws Exception {
        nav.ClickBottomNavLink(BotNavLinks.GIFTCARDS);
    }
}