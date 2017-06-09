package com.hbcd.testscript.commonplatform.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.InputData;
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
		pdp.AddToBag(1);
		Thread.sleep(1000L); // accommodating the slow overlay
		ValidateAemPdp.numberOfItemsAddedOverlayMessage(1);

	}
}