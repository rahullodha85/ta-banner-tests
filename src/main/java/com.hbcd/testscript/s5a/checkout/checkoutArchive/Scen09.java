package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.utility.helper.Common;

public class Scen09 extends ScenarioChkout{
	public void executeScript() throws Exception{
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		int unique=Common.getUniqueNumber();
		rsp.AddBillingAddress(dataObject.getAddress1()+unique,dataObject.getCity(),dataObject.getState(),dataObject.getZipCode(),dataObject.getCountry(), true);
		
		ValidateRs.BillingAddressContains(dataObject.getAddress1()+unique);
		shp.ClickCheckoutOptionalAddressConfirmation();
		shp.ClickCheckoutOptionalAddressConfirmation();
		rsp.ClickPlaceOrder();
		yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
		yap.ClickBillingAddressBook();
		Alert.Confirm();
		yap.removeFromBillingAddressBook(dataObject.getAddress1()+unique);
	}
}
