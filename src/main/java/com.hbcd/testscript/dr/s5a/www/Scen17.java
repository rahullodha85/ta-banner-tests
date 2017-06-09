package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen17 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0405294548649 ");
		prp.ClickFirstQuickLook();
		qlo.AddToBag(1);
	}
}