package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen42 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		String item2 = itemData.get(ItemType.DROPSHIP);
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("abcd@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation", "Item1", "no wrap");
		rsp.MakeGift(item2).With("Automation1", "Item1", "no wrap");
		ValidateRs.isGift(dataObject.getSkuListInfo().get(0));
		ValidateRs.isGift(item2);
		ValidateRs.hasRestrictedShippingMethod(item2);
//		rsp.ClickEditShippingMethod("0499928820294", ShipMethod.RUSH);
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGiftWrapApplied(dataObject.getSkuListInfo().get(0), "no wrap");
		ValidateConfirmation.isGiftWrapApplied(item2, "no wrap");
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}

}
