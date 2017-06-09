package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen30 extends ScenarioMobileSaks{

	@Override
	public void executeScript() throws Exception {
		String item1 = dataObject.getSkuListInfo().get(0);

		nav.SearchFor(item1);
		ValidatePrp.ProdutReviewStars();

	}

	
}
