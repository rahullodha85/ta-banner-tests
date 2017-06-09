package com.hbcd.testscript.s5a.paypal;


import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen02 extends ScenarioPaypal {
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("golamNC@s5a.com");
		shp.AddShippingAddress(false, "1330 7th avenue", "New York", "Manhattan", "10017",false);

		pap.AddNewCreditCard(10);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.ContinueWithPaypal();
		plog.LoginWithPaypal("su_1342452955_per@s5a.com", "test2012");
		
		pinf.continueFromPaypal();
		ValidateRs.ShippingAddressContains("San Jose");
		ValidateRs.BillingAddressContains("San Jose");

		rsp.ClickPlaceOrder();
	
		ValidateConfirmation.isThankYouPage();
		
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		yap.Go();
		yap.AccessOrderStatus(Storage.get("orderNumber"),"95131");
		//ValidateYap.hasPaypalPayment();
		
	}
}
