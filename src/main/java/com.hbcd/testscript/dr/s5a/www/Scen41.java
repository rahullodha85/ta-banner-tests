package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.validations.s5a.ValidateStoreLocationEvents;
import com.hbcd.base.ScenarioSaks;

public class Scen41 extends ScenarioSaks {
	/*
	1. Search events by zip code - search for events using zip code field	1. Events should show based on the zip code enter with closest events first
	 */

	@Override
	public void executeScript() throws Exception {

		nav.ClickBottomNavLink(BotNavLinks.STORELOCATIONSEVENTS);
		ValidateStoreLocationEvents.StoreLocationEventsPage();
		slp.SearchBy("10017");
		slp.StoreEvents();
		//check dates
		ValidateStoreLocationEvents.ClosestEventFirst();
}
}