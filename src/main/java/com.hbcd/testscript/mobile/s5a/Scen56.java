package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen56 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

			nav.SearchFor("sale ");
			ValidatePrp.FirstItemHas("Was");
			ValidatePrp.FirstItemHas("Now");
			prp.ClickFirstItem();
			ValidatePdp.hasSalePriceWasNow();
			
	
	}
}