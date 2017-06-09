package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.mobile.saks.validations.ValidateNavigation;
import com.hbcd.banner.validations.s5a.ValidatePrp;
import com.hbcd.banner.validations.s5a.mobile.ValidateNav;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen45 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {

		ValidateHome.Logo();
		ValidateHome.NeedHelp();
		ValidateHome.SearchBox();
		ValidateHome.SearchButton();
		ValidateHome.Stores();
		ValidateHome.SaksBag();
		
		ValidateNavigation.ValidateSinglePromo();
		
		prp.ClickPromoSlider();
		ValidateHome.PromoCode("FREESHIP");
		
		ValidateNav.hasSearchPredict("PRADA");
		SearchFunction.ClickFirstResultAfterSearch("PRADA");
		ValidatePrp.hasSearchFor("SEARCH TERM: PRADA");
		ValidateNav.hasSearchPredict("dresses");
		SearchFunction.ClickFirstResultAfterSearch("dresses");
		prp.ClickShopAll();
		ValidatePrp.FirstItemProductDetailHas("Dress");
}
}