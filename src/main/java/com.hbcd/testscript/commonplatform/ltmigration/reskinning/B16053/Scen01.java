package com.hbcd.testscript.commonplatform.ltmigration.reskinning.B16053;


import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateNav;
import com.hbcd.base.ScenarioCommonPlatform;


public class Scen01 extends ScenarioCommonPlatform {

    public void executeScript() throws Exception {

        ValidateNav.hasChatLink();
        ValidateNav.hasPhoneNumber();
        ValidateNav.hasBag();
    }
}
