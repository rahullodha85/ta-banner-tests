package com.hbcd.testscript.s5a.o5headerfooter;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class PredictiveSearch extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        Find.Object("ofm_navSearchBox_wk").click();
        Find.Object("SearchItemFieldTxtBx").input("ab");


        if(Find.Object("o5m_firstSearchPrediction").isPresent() &&
                Find.MultipleObjects("o5m_searchPredictions").size() > 0)
            Report.pass("predictions present");
        else Report.fail("no predictions available");
    }
}
