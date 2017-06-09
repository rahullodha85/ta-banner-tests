package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;

public class Scen07 extends ScenarioSaks{

	/**
	 * 1.From Sale page, select designer from Shop By Designer dropdown
	 */

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.SALE);
		nav.SelectDesigner("3.1 Phillip Lim");
	}
}
