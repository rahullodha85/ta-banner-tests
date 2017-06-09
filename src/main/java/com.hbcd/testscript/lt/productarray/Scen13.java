package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen13 extends ScenarioChkout{
	//Saks Nightly: Excluded
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		ValidateProductArray.leftNavText("WOMEN");
		sec.ClickPremierDesigner();
		ValidateProductArray.refinedBy("Premier Designer");
		prp.RefineByLifeStyle("Premier Designers"); // to toggle OFF COME BACKKKK
		prp.RefineByLifeStyle("Modern");
		ValidateProductArray.refinedBy("Modern");

	}
}
