package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen43 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0457095647182");
		pdp.AddToBag(1);
		nav.SearchFor("0457104292600");
		pdp.PersonalizeAddToBag(1,"Personalized text");
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword();
		pap.ClickCheckout();
		ValidateRs.isDropship("0457095647182");
		ValidateRs.isPersonalized("0457132943680", "Personalized text");
		rsp.ClickPlaceOrder();
		conf.EnterPassword("test123", "test13");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
		conf.EnterPassword("test", "test");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.CreateAccount();
		yap.Login(Storage.get("email"), "test123");
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
		
	}

}
