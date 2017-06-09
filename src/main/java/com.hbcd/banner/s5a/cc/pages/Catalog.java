package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Catalog {
	public void ClickBrand() throws Exception {
		switchToFrame();
		StepLogger.validate(Check.ObjectPresent, "ccCatalogBrandBtn_wk");
		Find.Object("ccCatalogBrandBtn_wk").click();
//		StepLogger.validate(Check.TextPresent, "ccFrameId_wk", "Womens's Apparel");
		Switch.toDefaultContent();
	}
	public void Click10Crosby() throws Exception {
		switchToFrame();
		StepLogger.validate(Check.ObjectPresent, "ccCatalog10CrosbyBtn_wk");
		Find.Object("ccCatalog10CrosbyBtn_wk").click();
//		StepLogger.validate(Check.TextPresent, "ccFrameId_wk", "Number of Items to display");
		Switch.toDefaultContent();
	}
	private void switchToFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}
}
