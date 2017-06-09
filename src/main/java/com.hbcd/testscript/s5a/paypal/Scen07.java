package com.hbcd.testscript.s5a.paypal;

import com.hbcd.banner.validations.s5a.ValidateYap;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen07 extends ScenarioPaypal{
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		pdp.EnterBag();

		bag.ClickPaypal();
		plog.LoginWithPaypal("su_1342452955_per@s5a.com", "test2012");
		pinf.continueFromPaypal();
		
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		yap.Go();
		yap.AccessOrderStatus(Storage.get("orderNumber"),"95131");
		ValidateYap.hasPaypalPayment();
		
	}
}
