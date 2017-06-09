package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;

public class SearchWebid extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor(InputData.get("item1").value());
        ValidatePdp.hasItemNumber(InputData.get("item1").value());
    }
}
