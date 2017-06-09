package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.Storage;

public class Scen48 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(2));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		Alert.Confirm();
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(2));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("sukhbir033@yahoo.com");
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		conf.CreateAccount();
		conf.GoToYourAccount();
		ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
		ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));
	}
}