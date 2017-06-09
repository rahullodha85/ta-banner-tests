package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen48 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		nav.SearchFor("0400087587687");
		ValidatePdp.hasItemNumber("0400087587687");
		ValidatePdp.hasBrandName("Adrianna Papell");
		ValidatePdp.hasSPD("Embroidered Lace Dress");
		ValidatePdp.hasPrice("79.99");
		pdp.AddToBag(1);
		pdp.EnterBag();
		ValidatePdp.bagCount("1");
		
}
}