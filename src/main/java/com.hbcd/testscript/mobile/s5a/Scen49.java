package com.hbcd.testscript.mobile.s5a;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.enums.SortOptions;

public class Scen49 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		prp.ClickBreadcrum("Women's Apparel");
		prp.ClickBreadcrum("Dresses");
		prp.ClickBreadcrum("Shop All");
		prp.SortBy(SortOptions.BESTSELLERS);
		prp.FilterByDesigner("ABS");
		
		prp.ClickLogo();
		prp.ClickBreadcrum("Shoes");
		prp.ClickLogo();
		prp.ClickBreadcrum("Handbags");
		prp.ClickBreadcrum("Wallets");
		prp.ClickLogo();
		prp.ClickBreadcrum("Jewelry");
		prp.ClickBreadcrum("Sunglasses");
		prp.ClickLogo();
		prp.ClickBreadcrum("Beauty");
		prp.ClickLogo();
		prp.ClickBreadcrum("Men");
		prp.ClickLogo();
		prp.ClickBreadcrum("Kids");
		prp.ClickLogo();
		prp.ClickBreadcrum("Home");
		prp.ClickLogo();
		
}
	
}
