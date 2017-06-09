package com.hbcd.testscript.commonplatform.SEO;

import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioCommonPlatform;

public class Scen06 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		sec.ClickJacketsAndVests();
		sec.ClickJackets();
		sec.ClickBlazers();
		sec.RefineBy("Designer", "Akris Punto");
		sec.RefineByColor("Blue");
		sec.RefineBySize("16");
		prp.SortBy(SortOptions.NEWARRIVALS);
	}

}
