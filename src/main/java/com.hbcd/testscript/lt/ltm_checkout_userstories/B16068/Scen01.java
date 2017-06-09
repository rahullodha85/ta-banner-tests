package com.hbcd.testscript.lt.ltm_checkout_userstories.B16068;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateNav;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.enums.TopNavLinks;

/**
 * Created by aalfaruk on 11/1/2016.
 * Change Designer to Brand on Top Header
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{

    nav.ClickNavigationLinks(TopNavLinks.BRANDS);
    ValidateNav.isBrandContainerAvailable();
    }
}
