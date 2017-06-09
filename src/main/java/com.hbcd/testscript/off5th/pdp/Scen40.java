package com.hbcd.testscript.off5th.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen40 extends ScenarioCommonPlatform {
    //International Item: India currency displayed
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("India");
        BrowserAction.javascriptExecuteScript("TINY.box.hide();");
        nav.SearchFor(InputData.get("indiaException").value());
        ValidateAemPdp.hasIndiaCurrency();
    }
}
