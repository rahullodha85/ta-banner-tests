package com.hbcd.testscript.s5a.quicklook;

import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.testdata.s5a.QuickLookData;

public class Scen05 extends ScenarioSaks {

	// Product Array  - Item is in Stock on the Web and in Store
	public void executeScript() throws Exception {
		nav.SearchFor(String.valueOf(QuickLookData.QLITMSC04));
		prp.ClickFirstQuickLook();
		ValidateQL.isQLViewProductDetailLink();
	}

}
