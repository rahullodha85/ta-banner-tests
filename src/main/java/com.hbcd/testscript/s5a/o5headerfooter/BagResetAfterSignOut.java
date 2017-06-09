package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;

public class BagResetAfterSignOut extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        //count is incremented when adding to bag
        nav.ClickSignIn();
        yap.Login("zeroBag@signedout.com", "test123");


        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor("0400088360968");
        pdp.AddToBag();

        nav.ClickSignOut();
        ValidatePdp.TotalItemsInBag("1");
    }
}
