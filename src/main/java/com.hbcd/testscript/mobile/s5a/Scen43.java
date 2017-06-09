package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.banner.validations.s5a.mobile.ValidateNav;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen43 extends ScenarioMobileSaks{


	@Override
    public void executeScript() throws Exception {

		SearchFunction.ClickFirstResultAfterSearch("dre");
		ValidatePrp.ValidateBreadCrumb("DRESSES");
	}
}
