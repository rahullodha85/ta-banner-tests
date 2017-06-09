package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.validations.s5a.ValidateStoreLocationEvents;
import com.hbcd.base.ScenarioSaks;

public class Scen40 extends ScenarioSaks {
	@Override
	public void executeScript() throws Exception {
		nav.ClickBottomNavLink(BotNavLinks.STORELOCATIONSEVENTS);
		ValidateStoreLocationEvents.StoreLocationEventsPage();
		slp.SearchBy("New York", "New York");
		ValidateStoreLocationEvents.ClosestStoreFirst();
		slp.StoreEvents();
		ValidateStoreLocationEvents.ClosestEventFirst();
	}
}