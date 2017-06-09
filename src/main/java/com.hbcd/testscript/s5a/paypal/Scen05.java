package com.hbcd.testscript.s5a.paypal;

import com.hbcd.banner.validations.Paypal.ValidatePaypalConfirmation;
import com.hbcd.banner.validations.Paypal.ValidatePaypalReview;
import com.hbcd.base.ScenarioPaypal;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen05 extends ScenarioPaypal{
	@Override
	public void executeScript() throws Exception {
		
		nav.ChangeCountry("Canada");
		nav.SearchFor("0400087699512");                    //(itemData.get(ItemType.REGULAR));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckoutInternational();

		shp.ClickCheckoutWithPaypal();
		
				
		plog.ClickPayWithMyPaypalAcc();
		plog.LoginWithPaypal("testbg5@test.com", "test2013");
		
		pinf.AddNewInternationalShippingAddress("Canada", "Hello World", "1722 Royal Oak Road", "Toronto", "Ontario", "M5A 1E1");
		pinf.continueFromPaypal();

		ValidatePaypalReview.BillingAddressContains("Canada");
		prev.ClickSubmitOrder();
		ValidatePaypalConfirmation.Confirmation();
		
	}
}
