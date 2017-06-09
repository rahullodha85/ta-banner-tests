package com.hbcd.testscript.s5a.quicklook;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.testdata.s5a.QuickLookData;


public class Scen13 extends ScenarioSaks {
	//Product Array - Quick look overlay validation
	public void executeScript() throws Exception {
		nav.SearchFor(QuickLookData.QLITMSC03.toString());
		ValidateProductArray.isQuickLookPresent();
		prp.ClickQLIconOnImage();
		ValidateQL.Overlay();
	}

}
