package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;

public class Scen57 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0499928820294");
		pdp.AddToBag(1);
		pdp.EnterBag();
		
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
		pdp.EnterBag();
		bag.ClickCheckout();
		ValidateRs.isItemPresent("0438369560316");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isItemPresent("0438369560316");
	}

}
