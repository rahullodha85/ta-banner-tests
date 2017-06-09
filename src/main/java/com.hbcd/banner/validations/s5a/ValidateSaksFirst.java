package com.hbcd.banner.validations.s5a;

import com.hbcd.commonbanner.enums.NavLinks;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 1/7/2016.
 */
public class ValidateSaksFirst {
    public static void isLeftNavLinkPresent(NavLinks link) throws Exception{
        if(Find.Object("saksFirstLeftNavTitles_RL").changeChildContainsText(link.toString()).isPresent()){
            Report.pass("Left navigation menu link: " + link + "is present on page",
                    BrowserAction.screenshot());
        }else{
            Report.fail("Left navigation menu link: " + link + "is not present on page",
                    BrowserAction.screenshot());
        }
    }
}
