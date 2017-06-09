package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen30 extends ScenarioChkout{
	//Saks Nightly: Included
	//check with abdullah
	// not working right now
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		sec.ClickJustKids();
		ValidateProductArray.isPageTitleBySearchResult("Kids");
		prp.clickFirstItem();
	}
}
