package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;

public class Scen37 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.ClickBottomNavLink(BotNavLinks.SAKSFIRST);
		//saks point page  should display
		//current total points should display
		//no options for redemption
		//The following should be displayed: SaksFirst points will be automatically converted into a SaksFirst gift card that you will receive in February 2014. Please call SaksFirst customer service at1.800.871.7257 for further questions.
		//Note: Redemptions in December and January will be disabled.  
	}
}
