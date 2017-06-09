package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;

public class AddToBagCount extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        //count is incremented when adding to bag
        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor(InputData.get("item1").value());
        pdp.AddToBag();
        ValidatePdp.TotalItemsInBag("1");
    }
}
