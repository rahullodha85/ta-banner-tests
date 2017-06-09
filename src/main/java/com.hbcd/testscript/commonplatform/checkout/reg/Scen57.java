package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;

public class Scen57 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0499928820294");
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		
		bag.ClickCheckout().LoginWith("sukhbirsinghwalia033@yahoo.com");
		//strange behavior shows billing address page instead of shipping apge

		shp.AddBillingAddress("13 East 49th St", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
//		ValidateRs.isVegc("0499928820294");
		
		nav.SearchFor("0438369560316");
		Alert.Confirm();
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout();
		ValidateRs.isItemPresent("0438369560316");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isItemPresent("0438369560316");
	}

}
