package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.utility.helper.Common;

public class Scen08 extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		int unique=Common.getUniqueNumber();
		rsp.AddShippingAddress(dataObject.getAddress1()+unique,dataObject.getCity(),dataObject.getState(),dataObject.getZipCode(),false);
		ValidateRs.ShippingAddressContains(dataObject.getAddress1());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
		yap.ClickShippingAddressBook();
		Alert.Confirm();
		yap.removeFromShippingAddressBook(dataObject.getAddress1()+unique);
	}
}