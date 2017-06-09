
package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen28 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.SearchFor("Women");
		ValidateProductArray.isPageTitleByKeyWordSearched("WOMEN");
		prp.ClickFirstItem();
	}
}
