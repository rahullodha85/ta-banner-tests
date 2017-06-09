package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen20 extends ScenarioSaks{
	/**
	 * 1.Verify the Shop the Look items in Product Detail page
	 */
	@Override
	public void executeScript() throws Exception {
		String stlItem1= itemData.get(ItemType.STL);
		nav.SearchFor(stlItem1);
		ValidatePdp.hasSTL();
	}
}
