package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateThankYou;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen44 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		//add preorder validation
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
