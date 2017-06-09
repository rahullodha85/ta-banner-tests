package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen47 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		/*String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.DROPSHIP);
		String item3=itemData.get(ItemType.STL);*/
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(2));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
//		ValidateLl.isEmailValid();
		
		
	}
}
