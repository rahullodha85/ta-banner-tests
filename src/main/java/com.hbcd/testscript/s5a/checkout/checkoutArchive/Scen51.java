package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen51  extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		nav.SearchFor("0424160097005");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "13 East 49th St", "New York", "New York", "10017",true);
		shp.ClickCheckoutOptionalAddressConfirmation();
		//rsp.AddShippingAddress("12 east 49th st", "New York", "NY", "10017",false);
		//rsp.AddBillingAddress("12 east 49th st", "New York", "NY", "10017", "USA",false);
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		//validate non associate discount
		conf.CreateAccount();
		conf.GoToYourAccount();
		conf.EnterPassword("ds&", "test1234");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test1234");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
	}
}
