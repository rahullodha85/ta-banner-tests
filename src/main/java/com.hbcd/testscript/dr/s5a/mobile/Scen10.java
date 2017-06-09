package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen10 extends ScenarioMobileSaks {
	
	@Override
	public void executeScript() throws Exception{
		nav.SearchFor("0438386556826");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.selectShippingMethod("Rush");
		bag.CheckOut();
		ValidateBag.ValidateShippingDate("");
		lgn.LoginWith("testc1@test.com", "123456ab");
		rsp.SelectCreditCard("Visa");
		ValidateRs.ValidateBillingAddressContains("12 E 49th St");
		ValidateRs.ValidateShippingAddressContains("12 E 49th St");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankyouPage();
		cop.CancelOrder();
	}
	}


