package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.scripting.core.Storage;

public class Scen53 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		nav.SearchFor("beauty");
		prp.ClickBreadcrum("Jewelry");
		prp.ClickBreadcrum("Fine Jewelry");
		prp.ClickBreadcrum("Earrings");
		prp.SortBy(SortOptions.BESTSELLERS);
		prp.ClickFirstItem();
		ValidatePdp.hasBrandName(Storage.get("prpFirstItemBrandName"));
		
		
}
}