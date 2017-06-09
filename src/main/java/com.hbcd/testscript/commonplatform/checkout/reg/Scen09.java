package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen09 extends ScenarioCommonPlatform{
	public void executeScript() throws Exception{
		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(2);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		pap.ContinueCheckoutPaymentPage();
		int uniqueNumber=Common.getUniqueNumber();
		rsp.AddBillingAddress(dataObject.getAddress1()+uniqueNumber,dataObject.getCity(),dataObject.getState(),dataObject.getZipCode(),dataObject.getCountry(), true);
		ValidateRs.BillingAddressContains(dataObject.getAddress1()+uniqueNumber);
		rsp.ClickPlaceOrder();
	}
}
