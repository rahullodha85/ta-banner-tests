package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen14 extends ScenarioMobileSaks{

    /**
     *  1. Navigate to WOMEN'S APPAREL,    click  Dresses>Day links
         takes to Product Array page
         2.Click on Filter By
         3.Click on  Sort By
     The Filter By overlay should display with all applicable filters, such as:
     - Designer
     - Size
     - Color
     - Lifestyle
     - Heel Hight

     . Overlay displays with following sort otions:
     - Newest
     - Best Sellers
     - Top Rated
     - Price: Low to High
     - Designers: A to Z
     - Category
     - Sale First
     */

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		sec.ClickShopAll();
        ValidatePrp.hasFilters();
        ValidatePrp.hasSorts();
	}
}
