package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;

public class Scen03 extends ScenarioSaks{

	// Bottom Nav items validations

	@Override
	public void executeScript() throws Exception {
		nav.ClickBottomNavLink(BotNavLinks.CUSTOMERSERVICE);
		nav.ClickBottomNavLink(BotNavLinks.STORELOCATIONSEVENTS);
		nav.ClickBottomNavLink(BotNavLinks.DOMESTIC);
		nav.ClickBottomNavLink(BotNavLinks.INTERNATIONAL);
		nav.ClickBottomNavLink(BotNavLinks.ORDERSTATUSTRACKING);
		nav.ClickBottomNavLink(BotNavLinks.SAKSFIRST);
		nav.ClickBottomNavLink(BotNavLinks.PAYBILLSMANAGE);

	}
}
