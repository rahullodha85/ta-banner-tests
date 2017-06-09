package com.hbcd.testscript.commonplatform.SEO;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioCommonPlatform;

public class Scen05 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.SelectFirstDesigner();
	}
}
