package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen51 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		nav.SearchFor("0496813466940");
		ValidatePdp.hasBrandName("Diane von Furstenberg");
		ValidatePdp.hasSPD("Ernestina Dress");
		ValidatePdp.hasColorSwatches();
		
	}
}
