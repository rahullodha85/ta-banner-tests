package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.commomplatform.fullsite.pages.SignInPage;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;

public class BagCountOnVariousPages extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        //count is incremented when adding to bag
        //zeroBag@signedout.com


        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor(InputData.get("specialChar1").value());
        nav.ClickSignIn().LoginWith(InputData.get("email").value(), InputData.get("password").value());

        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor(InputData.get("item1").value());
        pdp.AddToBag();
        Find.Object("ofm_navSearchBox_wk").click();

        nav.SearchFor("");
        ValidatePdp.TotalItemsInBag("1");

        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor("chanel");
        ValidatePdp.TotalItemsInBag("1");
    }
}
