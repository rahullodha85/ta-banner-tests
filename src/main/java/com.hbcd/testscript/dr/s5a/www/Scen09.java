package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.base.ScenarioSaks;
import org.apache.commons.lang.Validate;

public class Scen09 extends ScenarioSaks{

	/**
	 * 1. From Main home page, select a category (example Women's Apparel) from the top navigation
	 2, From Section page select a Brand from the Shop By Designer Dropdown
	 example:  Alexander Wang

	 */

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.SelectDesigner("Alexander Wang");
	}
}
