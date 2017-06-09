package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;

public class Scen57 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		
		bag.ClickCheckout().LoginWith("sukhbirsinghwalia033@yahoo.com");

		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
		//pap.AddNewCreditCard(3);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
//		ValidateRs.isVegc("0499928820294");
		
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		Alert.Confirm();
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		//ValidateRs.isItemPresent(dataObject.getSkuListInfo().get(1));
		bag.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isItemPresent(dataObject.getSkuListInfo().get(1));
	}

}
