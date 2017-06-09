package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.TopNavLinks;

public class Scen04 extends ScenarioMobileSaks{

	@Override
	public void executeScript() throws Exception{
		/*nav.ClickNavigationLinks(TopNavLinks.SALE);
		sec.ClickShopAll();*/
		nav.SearchFor("0410206883695 ");
		ValidatePrp.isLandingPage();
		ValidatePrp.isPricePresent();
		prp.ClickFirstItem();
		ValidatePdp.hasBrandName("Lilly Pulitzer");
		ValidatePdp.hasQuantityDropdown();
		ValidatePdp.hasColorSizeDropDown();
		ValidatePdp.hasSPD("Hayden Cardigan");
		ValidatePdp.hasItemNumber("0410206883695");
		ValidatePdp.hasPriceWasNow("Was");
		ValidatePdp.hasPriceWasNow("Now");
		
		
	}
}
