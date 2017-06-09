package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.SortOptions;

public class Scen57 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
//		ValidatePdp.recommendsDotsClickable();
		Thread.sleep(3000L);
		ValidatePdp.hasRecommendationSection();
		ValidatePdp.hasRichRelDetails();
		nav.SearchFor("0400087064788");
		Thread.sleep(3000L);
		ValidatePdp.hasRecommendationSection();
		ValidatePdp.hasRecommendationDots();
		ValidatePdp.recommendsDotsClickable();
	}
	
}
