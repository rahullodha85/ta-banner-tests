package com.hbcd.testscript.mobile.off5th;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/22/2016.
 */
public class Scen26 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("regular").value());
        ValidateAemPdp.hasSharingIcons();
    }
}
