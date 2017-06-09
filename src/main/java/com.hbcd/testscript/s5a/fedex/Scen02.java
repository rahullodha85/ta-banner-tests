package com.hbcd.testscript.s5a.fedex;

import com.hbcd.banner.valiations.webservice.WebserviceValidation;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.dataobjects.Address;

public class Scen02 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor("0468064577744");
		pdp.AddToBag(1);
		nav.SearchFor("0421303775875");
		pdp.AddToBag(1);
		nav.SearchFor("0424147508739");
		pdp.AddToBag(1);
		nav.SearchFor("0462451774457");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("sukhbir_walia@s5a.com");
		shp.AddShippingAddress(false, "12 East 49th Street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
	
		WebserviceValidation.isReturningFdxShpngDts(Address.createAddress("Tester", "Automation", "12 East 49th Street", "New York", "NY", "10017", "9176132888"));
		
		rsp.ChangeShippingMethod("rush");
		ValidateRs.ValidateShippingDate("0468064577744");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isShippingChargeApplied();
		
	}

}
