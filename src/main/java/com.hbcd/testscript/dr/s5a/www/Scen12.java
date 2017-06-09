package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;

public class Scen12 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.ClickLeftNavLink("Dresses");
		ValidatePrp.hasBreadCrumb("Dresses");
		prp.RefineByDesigner("ABS");
		ValidateProductArray.refinedBy("ABS");
		prp.SortBy(SortOptions.SALE_SHOWFIRST);

	}
}
