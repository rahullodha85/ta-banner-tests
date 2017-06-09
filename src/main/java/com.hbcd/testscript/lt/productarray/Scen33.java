package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen33 extends ScenarioChkout{
	//Saks Nightly: Included
	//ask abdullah what is page title
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		nav.SelectDesigner("Gucci");
		//ValidateProductArray.isPageTitleByDesigner("Gucci");
//		sec.click();
		//validate LHn
	}
}
/*

 */