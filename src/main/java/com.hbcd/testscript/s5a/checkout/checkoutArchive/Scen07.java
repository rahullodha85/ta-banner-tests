package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.Find;
import com.hbcd.utility.helper.Common;

public class Scen07 extends ScenarioChkout{

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor(dataObject.getSkuListInfo().get(0));
//		pdp.AddToBag(1);
//		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
				rsp.ClickShipToMultipleAddresses();
		String address=dataObject.getAddress1()+Common.getUniqueNumber();
		rsp.EnterNewShippingAddress(dataObject.getSkuListInfo().get(1), address, dataObject.getCity(), dataObject.getState(), dataObject.getZipCode(),false);
		
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
		nav.ClickSaksYourAccount();
		yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
//		Validate shipping address
		yap.ClickShippingAddressBook();
		
		Alert.Confirm();
		yap.removeFromShippingAddressBook(address);
	}
}
