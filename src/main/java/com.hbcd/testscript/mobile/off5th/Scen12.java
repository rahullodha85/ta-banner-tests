package com.hbcd.testscript.mobile.off5th;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen12 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {

		// Script seems incorrect. Checking with Zebun and Anne.
		// No SHipping Accordion displayed for Gift cards and no text related to
		// FREESHIP is displayed in Page
		nav.SearchFor(InputData.get("regular").value());
		ValidateAemPdp.shippingReturnsAccordion();
	}
}