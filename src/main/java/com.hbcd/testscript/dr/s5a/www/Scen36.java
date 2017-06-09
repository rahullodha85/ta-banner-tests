package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateSaksFirst;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.enums.BotNavLinks;
import com.hbcd.commonbanner.enums.NavLinks;

public class Scen36 extends ScenarioSaks {

    @Override
    public void executeScript() throws Exception {
		nav.ClickBottomNavLink(BotNavLinks.SAKSFIRST);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.SAKSFIRSTMEMBERSHIP);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.SAKSFIRSTMEMBERSHIP);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.SAKSFIRSTMASTERCARD);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.SAKSFIRSTSTORECARD);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.CONTACTSAKSFIRST);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.SAKSFIRSTACCOUNT);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.APPLYSAKSFIRSTSTORECARD);
        ValidateSaksFirst.isLeftNavLinkPresent(NavLinks.UPGRADESAKSFIRSTMASTERCARD);
        //left nav should have :
        //SAKSFIRST  MEMBERSHIP, SAKSFIRST STORE CARD, SAKSFIRST MASTERCARD, CONTACT SAKSFIRST.
        //right nav should have:
        //View SaksFirst Points, SaksFirst Account,  Pay Bills and Manage Saks Credit, SaksFirst Master Card, SaksFirst store Card, Apply Apply for the Saks Store Card, Upgrade to the Saks MasterCard
    }
}
