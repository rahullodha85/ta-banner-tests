package com.hbcd.testscript.s5a.PDP;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen09 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		// Pre-condition: Find an item that has a quantity limitation. The IMT
		// Attribute <purchaselimit> should be greater than 0. E.g.
		// 0438369560316
		String regularItem = itemData.get(ItemType.REGULAR);
		nav.SearchFor(regularItem);
		pdp.EnterQuantity(99);
		ValidateAemPdp.hasHighDemandMessage();
	}
}