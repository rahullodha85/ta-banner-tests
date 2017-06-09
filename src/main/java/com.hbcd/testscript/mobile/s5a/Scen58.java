package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.SortOptions;

public class Scen58 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		nav.SearchFor("0400087047898");
		pdp.AddToBag(1);
		nav.SearchFor("0400087064788");
		Thread.sleep(3000L);
		ValidatePdp.hasRecommendationSection();
		ValidatePdp.hasRecommendationDots();
		ValidatePdp.recommendsDotsClickable();
		ValidatePdp.hasRichRelDetails();
//		ValidatePdp.recommendationsNotInclude("0400087047898");
	}
	
}
