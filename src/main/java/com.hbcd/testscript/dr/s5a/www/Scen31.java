package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.common.paypal.pInformationPage;
import com.hbcd.banner.common.paypal.pLogin;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen31 extends ScenarioSaks{

	/**
		 1. As registered user with only Visa as of MOP
			add any item to the bag and proceed to the Saks Bag page.
	 		Proceed to checkout and select PayPal as MOP.
		 2. Follow the flow and place the order.
		 3. Go to the Account Login Page, click on PAYMENT METHOD link
		 	Whithin buyers remorse time proceed to the history page and cancel order
	 */

	@Override
	public void executeScript() throws Exception {
		String item1 = itemData.get(ItemType.REGULAR);
        pLogin plog = new pLogin();
        pInformationPage pinf = new pInformationPage();

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickPaypal();
        plog.LoginWithPaypal("su_1342452955_per@s5a.com", "test2012"); //this is a paypal login for sandbox environment
        pinf.continueFromPaypal();
        rsp.ClickPlaceOrder();
        Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
        yap.CancelOrder(Storage.get("orderNumber"), "95131"); //zip is linked to paypal account
	}
}
