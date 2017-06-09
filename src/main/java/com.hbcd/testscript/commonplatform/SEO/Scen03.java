package com.hbcd.testscript.commonplatform.SEO;

import com.hbcd.base.ScenarioCommonPlatform;

public class Scen03 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("Prada");
		sec.ClickFragnance();
		sec.ClickForHer();
	}

}
