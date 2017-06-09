package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen42 extends ScenarioChkout {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0499932227409");
		pdp.AddToBag(1);
		nav.SearchFor("0457095647182");
		pdp.AddToBag(1);
		nav.SearchFor("0499928820294");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, "12 E 49 street", "New York", "New York","10017",false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.MakeGift("0499932227409").With("Automation", "Item1", "no wrap");
		rsp.MakeGift("0457095647182").With("Automation1", "Item1", "white wrap");
		ValidateRs.isGift("0499932227409");
		ValidateRs.isGift("0457095647182");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftWrapApplied("0499932227409", "no wrap");
		ValidateConfirmation.isGiftWrapApplied("0457095647182", "white wrap");
		ValidateConfirmation.isGiftWrapApplied("0499928820294", "no box");
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));

	}

}
