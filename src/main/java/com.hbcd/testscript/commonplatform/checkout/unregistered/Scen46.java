package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen46 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.DROPSHIP);*/

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), false);
		pap.AddNewCreditCard(3);
		pap.ClickCheckout();
		//rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation", "Hello Automation", "Logo");
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Rainbow", "How are you");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isGift(dataObject.getSkuListInfo().get(0));
		conf.EnterPassword("ds&", "test1234");
		ValidateConfirmation.hasInvalidPasswordError();
		conf.EnterPassword("test123", "test1234");
		ValidateConfirmation.hasPasswordDoesnotMatchError();
	}
}
