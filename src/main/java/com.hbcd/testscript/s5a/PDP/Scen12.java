package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen12 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {

		// Script seems incorrect. Checking with Zebun and Anne.
		// No SHipping Accordion displayed for Gift cards and no text related to
		// FREESHIP is displayed in Page
		String regularItem = itemData.get(ItemType.REGULAR);
		nav.SearchFor(regularItem);
		ValidateAemPdp.shippingReturnsAccordion();
	}
}