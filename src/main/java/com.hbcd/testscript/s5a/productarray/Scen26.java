package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioChkout;

public class Scen26 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickDresses();
		ValidateProductArray.isPageTitleByKeyWordSearched("Dresses");
		prp.RefineByLifeStyle("Contemporary");
		prp.RefineByColor("Black");
		prp.RefineBySize("Medium");
		prp.RefineBy("Designer", "ABS");
		prp.RefineByPrice("$150 - $300");
		//clear & validate size refine 
	}
}
