package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen64 extends ScenarioSaks{

	/**
	 *1.From the Top Navigation, enter a keyword (e.x Shoes) on the search box and press <ENTER>
	 */

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("Shoes");
        ValidatePrp.FirstItemProductDetailHas("Shoes");
	}
}
