package com.hbcd.testscript.lt.productarray;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;
import com.hbcd.scripting.core.Find;

public class Scen34 extends ScenarioChkout{
	//Saks Nightly: Included
	//check with abdullah
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		Find.Object("brand_vev").isDisplayed();
		nav.SelectDesigner("Gucci");

		prp.clickFirstItem();
		//click first item
	}
}
