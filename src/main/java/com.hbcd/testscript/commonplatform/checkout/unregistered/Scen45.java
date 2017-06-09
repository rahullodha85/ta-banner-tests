package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen45 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.DROPSHIP);*/

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
		//pap.UpdateQuantity(dataObject.getSkuListInfo().get(0),"4");
		pap.AddNewCreditCard(3);
//		ValidatePymt.isQuantityUpdatedTo("0476703126079","4");
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
