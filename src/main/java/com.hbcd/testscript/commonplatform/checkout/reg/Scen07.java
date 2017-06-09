package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen07 extends ScenarioCommonPlatform{
	@Override
	public void executeScript() throws Exception {
		//String item1 = itemData.get(ItemType.REGULAR);
		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		nav.SearchFor(item1);
		pdp.AddToBag(2);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickShipToMultipleAddresses();
		rsp.EnterNewShippingAddress(dataObject.getSkuListInfo().get(1), dataObject.getAddress1() + Common.getUniqueNumber(), dataObject.getCity(), dataObject.getState(), dataObject.getZipCode(),false);
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
	}
}
