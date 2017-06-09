package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;

public class SearchSpecialChar extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {

        Find.Object("ofm_navSearchBox_wk").click();
        nav.SearchFor(InputData.get("specialChar1").value());
        //needs implementation
        ValidatePap.hasTextInResults(InputData.get("specialChar1").value());
    }
}
