package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen63 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{

		String item1 = itemData.get(ItemType.REGULAR);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		//add preorder validation
		ValidateRs.isAssociateDiscountApplied(false);
		rsp.ClickPlaceOrder();
		ValidateRs.isAssociateDiscountApplied(true);
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
		
	}
}
